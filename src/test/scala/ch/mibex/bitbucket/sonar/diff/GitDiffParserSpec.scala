  "diff headers mode" should {
  }

  "diff headers copy" should {

  }

  "diff headers rename and similarity" should {
  "parse binary diff" should {

    "parse without errors" in {
      binaryDiff must succeedOn(
        """diff --git a/public/vendor/swaggervel/fonts/droid-sans-v6-latin-700.eot b/public/vendor/swaggervel/fonts/droid-sans-v6-latin-700.eot
          |new file mode 100644
          |index 0000000000000000000000000000000000000000..d8524983ad8d296be95cb5b469efd1987d6e04e3
          |GIT binary patch
          |literal 22922
          |zcmZsCQ;;QG5AA8&wr$&|ZQHhc+O}=mnzn75)3!D3p8Nf8_g3BHAyq4@QhC@_$==zC
          |z)dm3SwEzIn{}deXpM`^l1cL?#1qBBI^nd~Y&;U85J5a#BE-^ru`al2wqyPj!{6D)M
          |z%&GZ5`~M0$00?jaI0CEzX8+Mt0mc9afa`x0Xn^Q{sNH`k06-7W0GR*Ba{Z6x_@AE`
          |zzye?dF#o5-026@wf9U^s|3g^-tpD)||GzPb|F4JufT*gZ(*K(Y000K~MGoMR0Vp>E
          |z7?M$EFQO-mHZ&)#WL+GcoJrMrP3W1@SvQZim+$w-EQRyC*2sl9OOp#iuEC=DNFU0Y
          |zu=jPv$K@pC>&OgLbsHAuV+;hb2z4e&N67~s+_XK5wd$(Ez4l=k{jD`bG?L0%;hm+W
          |z*tCmf^`$X6PG#>*MXv(|#p`rZ=w^%P8%t!u+AYLwS>YKlUJgNny(KWR&hishMXzlL
          |zuiT}Im15Pk0Fo-@fa$_6>Ww!eI<;B{4JE252|df+QTKx2sf4D4;|`-3sEBAorCqGj
          |z=*qV}ItaTwWQLZyN<d>?tU_poBTKDi(=H&u@TaI{UJ|^@y`E3U=Pc|`t+fj3)5@p!
          |zfwv`PwRCO%V~nu)owzHeSL_U!&JO9vwnnGO(NgPkL$HsO?g~^aF7CrEY<>h#y`e2o
          |b()wT*kWXAeMzX)G0;aHJLU2Us_FHkFnk)~p
          |
          |literal 0
          |HcmV?d00001
          |""".stripMargin)
    }

  }

              AddedLine( """        System.out.println( "Hello World! " + g);""")
              CtxLine( """#include "cache.h""""),
              CtxLine( """#include "walker.h""""),
    "parse diff with u0085 new line character" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/u0085-char-issue.txt"))
    }.pendingUntilFixed

    "Github issue #8" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/github#8.txt"))
    }

    "Github issue #8 no newline at eof" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/github#8-no-newline-at-eof.txt"))
    }

    "Github issue #8 wrong example 1" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/github#8-diff-wrong1.txt"))
    }

    "Github issue #8 wrong example 3" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/github#8-diff-wrong3.txt"))
    }

    "parse PR140 with multiple diffs successfully" in {
      allDiffs must succeedOn(StringUtils.readFile("/diffs/PR140.diff")).withResult(
        List(
          GitDiff(
            gitDiffHeader = FileChange("app/DataTransferObjects/Menu/Category/CategoryDTO.php", "app/DataTransferObjects/Menu/Category/CategoryDTO.php"),
            header = ExtendedDiffHeader(List(DeletedFileMode(100644)), Index("27e8967", "0000000", None)),
            hunks = List(
              Hunk(
                HunkHeader(FromToRange(1, 42, 0, 0), None),
                List(
                  RemovedLine("<?php"),
                  RemovedLine(""),
                  RemovedLine( """namespace App\DataTransferObjects\Menu\Category;"""),
                  RemovedLine(""),
                  RemovedLine( """use App\DataTransferObjects\DataTransferObjectTrait;"""),
                  RemovedLine( """use App\Models\Menu\Category\Category as CategoryModel;"""),
                  RemovedLine(""),
                  RemovedLine("/**"),
                  RemovedLine(" * Class Restaurant"),
                  RemovedLine(" *"),
                  RemovedLine( """ * @package app\DTO"""),
                  RemovedLine(" */"),
                  RemovedLine("class CategoryDTO"),
                  RemovedLine("{"),
                  RemovedLine("    use DataTransferObjectTrait;"),
                  RemovedLine(""),
                  RemovedLine("    /**"),
                  RemovedLine("     * Holds the model that we wish to convert to when we send in data"),
                  RemovedLine("     *"),
                  RemovedLine("     * @var"),
                  RemovedLine("     */"),
                  RemovedLine("    private $model = CategoryModel::class;"),
                  RemovedLine(""),
                  RemovedLine("    /**"),
                  RemovedLine("     * Holds all the mappings to convert from a DTO object to a model"),
                  RemovedLine("     *"),
                  RemovedLine("     * @var array"),
                  RemovedLine("     */"),
                  RemovedLine("    private $mappings;"),
                  RemovedLine(""),
                  RemovedLine("    /**"),
                  RemovedLine("     * RestaurantDTO constructor."),
                  RemovedLine("     *"),
                  RemovedLine("     * @param $data"),
                  RemovedLine("     */"),
                  RemovedLine("    public function __construct($data)"),
                  RemovedLine("    {"),
                  RemovedLine("        $this->data = $data;"),
                  RemovedLine(""),
                  RemovedLine("        return $this->map();"),
                  RemovedLine("    }"),
                  RemovedLine("}")
                )
              )
            )
          ),
          BinaryDiff(),
          GitDiff(
            FileChange("public/vendor/swaggervel/fonts/droid-sans-v6-latin-700.svg", "public/vendor/swaggervel/fonts/droid-sans-v6-latin-700.svg"),
            ExtendedDiffHeader(
              List(NewFileMode(100644)),Index("0000000","a54bbbb",None)
            ),
            List(
              Hunk(
                HunkHeader(FromToRange(0,0,1,12),None),
                List(
                  AddedLine("""<?xml version="1.0" standalone="no"?>"""),
                  AddedLine("""<!DOCTYPE svg PUBLIC "-//W3C//DTD SVG 1.1//EN" "http://www.w3.org/Graphics/SVG/1.1/DTD/svg11.dtd">"""),
                  AddedLine("""<svg xmlns="http://www.w3.org/2000/svg">"""),
                  AddedLine("<defs >"),
                  AddedLine("""<font id="DroidSans" horiz-adv-x="1123" ><font-face"""),
                  AddedLine("""    font-family="Droid Sans""""),
                  AddedLine("""    units-per-em="2048""""),
                  AddedLine("""    panose-1="2 11 8 6 3 8 4 2 2 4""""),
                  AddedLine("""    ascent="1907""""),
                  AddedLine("""    descent="-492""""),
                  AddedLine("""    alphabetic="0" />"""),
                  AddedLine("""<glyph unicode=" " glyph-name="space" horiz-adv-x="532" />""")
                )
              )
            )
          )
        )
      )
  val parsers = GitDiffParser // necessary for ParserMatchers