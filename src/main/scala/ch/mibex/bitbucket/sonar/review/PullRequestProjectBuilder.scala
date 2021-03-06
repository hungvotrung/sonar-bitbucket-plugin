package ch.mibex.bitbucket.sonar.review

import ch.mibex.bitbucket.sonar.{SonarBBPlugin, SonarBBPluginConfig}
import org.sonar.api.CoreProperties
import org.sonar.api.batch.bootstrap.ProjectBuilder
import org.sonar.api.config.Settings

// this builder is executed at the beginning of the SonarQube analysis
class PullRequestProjectBuilder(pluginConfiguration: SonarBBPluginConfig,
                                gitBaseDirResolver: GitBaseDirResolver,
                                settings: Settings) extends ProjectBuilder {

  override def build(context: ProjectBuilder.Context): Unit = {
    if (pluginConfiguration.isEnabled) {
      checkAnalysisMode()
      gitBaseDirResolver.init(context.projectReactor().getRoot.getBaseDir)
    }
  }

  private def checkAnalysisMode() {
    require(
      isDryRunMode || isPreviewMode || isIncrementalMode || isIssuesMode,
      s"""${SonarBBPlugin.PluginLogPrefix} The plug-in only works in preview or issues mode.
         |Please set "-Dsonar.analysis.mode" accordingly.""".stripMargin.replaceAll("\n", " "))
  }

  private def isIssuesMode = settings.getString(CoreProperties.ANALYSIS_MODE) == "issues"

  private def isIncrementalMode =
    settings.getString(CoreProperties.ANALYSIS_MODE) == CoreProperties.ANALYSIS_MODE_INCREMENTAL

  private def isPreviewMode =
    settings.getString(CoreProperties.ANALYSIS_MODE) == CoreProperties.ANALYSIS_MODE_PREVIEW

  private def isDryRunMode = settings.getBoolean(CoreProperties.DRY_RUN)

}
