package lombok.patcher;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/PatchScript.SCL.lombok */
public abstract class PatchScript {
    public abstract Collection<String> getClassesToReload();

    public abstract boolean wouldPatch(String str);

    public abstract byte[] patch(String str, byte[] bArr, TransplantMapper transplantMapper);

    public String getPatchScriptName() {
        return getClass().getSimpleName();
    }

    public static boolean classMatches(String className, Collection<String> classSpecs) {
        for (String classSpec : classSpecs) {
            if (MethodTarget.typeMatches(className, classSpec)) {
                return true;
            }
        }
        return false;
    }

    protected byte[] runASM(byte[] byteCode, boolean computeStacks, TransplantMapper transplantMapper) {
        ClassReader reader = new ClassReader(byteCode);
        int classFileFormatVersion = 48;
        if (byteCode.length > 7) {
            classFileFormatVersion = byteCode[7] & 255;
        }
        int flags = classFileFormatVersion < 50 ? 2 : 0;
        if (computeStacks) {
            flags |= 1;
        }
        ClassWriter writer = new PatchScript$FixedClassWriter(reader, flags);
        ClassVisitor visitor = createClassVisitor(writer, reader.getClassName(), transplantMapper);
        reader.accept(visitor, 0);
        return writer.toByteArray();
    }

    protected ClassVisitor createClassVisitor(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        throw new IllegalStateException("If you're going to call runASM, then you need to implement createClassVisitor");
    }

    private static byte[] readStream(String resourceName) {
        InputStream wrapStream = null;
        try {
            try {
                wrapStream = PatchScript.class.getResourceAsStream(resourceName);
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] b2 = new byte[65536];
                while (true) {
                    int r = wrapStream.read(b2);
                    if (r == -1) {
                        break;
                    }
                    baos.write(b2, 0, r);
                }
                byte[] byteArray = baos.toByteArray();
                if (wrapStream != null) {
                    try {
                        wrapStream.close();
                    } catch (IOException unused) {
                    }
                }
                return byteArray;
            } catch (Throwable th) {
                if (wrapStream != null) {
                    try {
                        wrapStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("resource " + resourceName + " does not exist.", e);
        }
    }

    protected static void insertMethod(Hook methodToInsert, MethodVisitor target) {
        byte[] classData = readStream(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN + methodToInsert.getClassSpec() + ".class");
        ClassReader reader = new ClassReader(classData);
        ClassVisitor methodFinder = new PatchScript$1(methodToInsert, target);
        reader.accept(methodFinder, 0);
    }

    protected static void transplantMethod(String resourceName, Hook methodToTransplant, ClassVisitor target) {
        byte[] classData = readStream(resourceName);
        ClassReader reader = new ClassReader(classData);
        ClassVisitor methodFinder = new PatchScript$2(methodToTransplant, target);
        reader.accept(methodFinder, 0);
    }
}
