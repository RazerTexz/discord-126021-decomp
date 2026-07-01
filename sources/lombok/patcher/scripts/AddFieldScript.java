package lombok.patcher.scripts;

import java.util.Collection;
import java.util.List;
import lombok.patcher.MethodTarget;
import lombok.patcher.PatchScript;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.FieldVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/AddFieldScript.SCL.lombok */
public class AddFieldScript extends PatchScript {
    private final int accessFlags;
    private final List<String> targetClasses;
    private final String fieldName;
    private final String fieldType;
    private final Object value;

    @Override // lombok.patcher.PatchScript
    public String getPatchScriptName() {
        return "AddField: " + this.fieldType + " " + this.fieldName + "to " + this.targetClasses;
    }

    AddFieldScript(List<String> targetClasses, int accessFlags, String fieldName, String fieldType, Object value) {
        if (targetClasses == null) {
            throw new NullPointerException("targetClass");
        }
        if (fieldName == null) {
            throw new NullPointerException("fieldName");
        }
        if (fieldType == null) {
            throw new NullPointerException("typeSpec");
        }
        this.accessFlags = accessFlags;
        this.targetClasses = targetClasses;
        this.fieldName = fieldName;
        this.fieldType = fieldType;
        this.value = value;
    }

    @Override // lombok.patcher.PatchScript
    public boolean wouldPatch(String className) {
        for (String tc : this.targetClasses) {
            if (MethodTarget.typeMatches(className, tc)) {
                return true;
            }
        }
        return false;
    }

    @Override // lombok.patcher.PatchScript
    public byte[] patch(String className, byte[] byteCode, TransplantMapper transplantMapper) {
        for (String tc : this.targetClasses) {
            if (MethodTarget.typeMatches(className, tc)) {
                return runASM(byteCode, false, transplantMapper);
            }
        }
        return null;
    }

    @Override // lombok.patcher.PatchScript
    protected ClassVisitor createClassVisitor(ClassWriter writer, String classSpec, TransplantMapper transplantMapper) {
        return new ClassVisitor(Opcodes.ASM7, writer) { // from class: lombok.patcher.scripts.AddFieldScript.1
            private boolean alreadyAdded = false;

            @Override // org.objectweb.asm.ClassVisitor
            public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
                if (name != null && name.equals(AddFieldScript.this.fieldName)) {
                    this.alreadyAdded = true;
                }
                return super.visitField(access, name, desc, signature, value);
            }

            @Override // org.objectweb.asm.ClassVisitor
            public void visitEnd() {
                if (!this.alreadyAdded) {
                    FieldVisitor fv = this.cv.visitField(AddFieldScript.this.accessFlags, AddFieldScript.this.fieldName, AddFieldScript.this.fieldType, null, AddFieldScript.this.value);
                    fv.visitEnd();
                }
                super.visitEnd();
            }
        };
    }

    @Override // lombok.patcher.PatchScript
    public Collection<String> getClassesToReload() {
        return this.targetClasses;
    }
}
