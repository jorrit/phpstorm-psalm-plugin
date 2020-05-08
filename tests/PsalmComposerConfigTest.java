import com.intellij.openapi.util.SystemInfo;
import com.jetbrains.php.config.composer.QualityToolsComposerConfigTest;
import com.jetbrains.php.tools.quality.QualityToolConfigurationManager;
import com.jetbrains.php.tools.quality.psalm.PsalmConfigurationManager;
import org.jetbrains.annotations.NotNull;

public class PsalmComposerConfigTest extends QualityToolsComposerConfigTest {

  @Override
  protected QualityToolConfigurationManager getQualityToolConfigurationManager() {
    return PsalmConfigurationManager.getInstance(getProject());
  }

  @NotNull
  @Override
  protected String getPath() {
    return "bin/psalm" + (SystemInfo.isWindows ? ".bat" : "");
  }

  @NotNull
  @Override
  protected String getPackageName() {
    return "vimeo/psalm";
  }
}
