package lombok.patcher;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/patcher/ScriptManager$OurClassFileTransformer.SCL.lombok */
class ScriptManager$OurClassFileTransformer implements ClassFileTransformer {
    final /* synthetic */ ScriptManager this$0;

    private ScriptManager$OurClassFileTransformer(ScriptManager scriptManager) {
        this.this$0 = scriptManager;
    }

    /* synthetic */ ScriptManager$OurClassFileTransformer(ScriptManager scriptManager, ScriptManager$OurClassFileTransformer scriptManager$OurClassFileTransformer) {
        this(scriptManager);
    }

    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] transformed;
        if (className == null) {
            return null;
        }
        List<ScriptManager$WitnessAction> actions = (List) ScriptManager.access$0(this.this$0).get(className);
        if (actions != null) {
            for (ScriptManager$WitnessAction wa : actions) {
                if (!wa.triggered) {
                    wa.triggered = true;
                    if (wa.ifWitnessRemove) {
                        ScriptManager.access$1(this.this$0).remove(wa.script);
                    } else {
                        ScriptManager.access$1(this.this$0).add(wa.script);
                    }
                }
            }
        }
        if (!ScriptManager.access$2(this.this$0).shouldTransform(loader, className, classBeingRedefined, protectionDomain, classfileBuffer)) {
            return null;
        }
        byte[] byteCode = classfileBuffer;
        boolean patched = false;
        for (PatchScript script : ScriptManager.access$1(this.this$0)) {
            try {
                transformed = script.patch(className, byteCode, ScriptManager.access$3(this.this$0));
            } catch (Throwable t) {
                System.err.printf("Transformer %s failed on %s. Trace:\n", script.getPatchScriptName(), className);
                t.printStackTrace();
                transformed = null;
            }
            if (transformed != null) {
                patched = true;
                byteCode = transformed;
            }
        }
        if (patched && ScriptManager.access$4() != null) {
            try {
                writeArray(ScriptManager.access$4(), String.valueOf(className) + ".class", byteCode);
                writeArray(ScriptManager.access$4(), String.valueOf(className) + "_OLD.class", classfileBuffer);
            } catch (IOException e) {
                System.err.println("Can't log patch result.");
                e.printStackTrace();
            }
        }
        if (patched) {
            return byteCode;
        }
        return null;
    }

    private void writeArray(String dir, String fileName, byte[] bytes) throws IOException {
        File f = new File(dir, fileName);
        f.getParentFile().mkdirs();
        FileOutputStream fos = new FileOutputStream(f);
        fos.write(bytes);
        fos.close();
    }
}
