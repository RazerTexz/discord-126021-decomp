package lombok.bytecode;

import java.util.concurrent.atomic.AtomicBoolean;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompilerTransformation;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/bytecode/PreventNullAnalysisRemover.SCL.lombok */
public class PreventNullAnalysisRemover implements PostCompilerTransformation {
    @Override // lombok.core.PostCompilerTransformation
    public byte[] applyTransformations(byte[] original, String fileName, DiagnosticsReceiver diagnostics) {
        if (!new ClassFileMetaData(original).usesMethod("lombok/Lombok", "preventNullAnalysis")) {
            return null;
        }
        byte[] fixedByteCode = AsmUtil.fixJSRInlining(original);
        ClassReader reader = new ClassReader(fixedByteCode);
        ClassWriter writer = new FixedClassWriter(reader, 0);
        AtomicBoolean changesMade = new AtomicBoolean();
        reader.accept(new PreventNullAnalysisRemover$1(this, Opcodes.ASM7, writer, changesMade), 0);
        if (changesMade.get()) {
            return writer.toByteArray();
        }
        return null;
    }
}
