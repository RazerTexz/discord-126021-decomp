package lombok.javac.apt;

import java.nio.charset.CharsetDecoder;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/apt/LombokFileObject.SCL.lombok */
interface LombokFileObject extends JavaFileObject {
    CharsetDecoder getDecoder(boolean z2);
}
