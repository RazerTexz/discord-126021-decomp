package lombok.patcher.scripts;

import java.util.Collection;
import java.util.List;
import lombok.patcher.MethodTarget;
import lombok.patcher.PatchScript;
import lombok.patcher.TransplantMapper;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/AddFieldScript.SCL.lombok */
public class AddFieldScript extends PatchScript {
    private final int accessFlags;
    private final List<String> targetClasses;
    private final String fieldName;
    private final String fieldType;
    private final Object value;

    static /* synthetic */ int access$1(AddFieldScript addFieldScript) {
        return addFieldScript.accessFlags;
    }

    static /* synthetic */ String access$0(AddFieldScript addFieldScript) {
        return addFieldScript.fieldName;
    }

    static /* synthetic */ String access$2(AddFieldScript addFieldScript) {
        return addFieldScript.fieldType;
    }

    static /* synthetic */ Object access$3(AddFieldScript addFieldScript) {
        return addFieldScript.value;
    }

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
        return new AddFieldScript$1(this, Opcodes.ASM7, writer);
    }

    @Override // lombok.patcher.PatchScript
    public Collection<String> getClassesToReload() {
        return this.targetClasses;
    }
}
