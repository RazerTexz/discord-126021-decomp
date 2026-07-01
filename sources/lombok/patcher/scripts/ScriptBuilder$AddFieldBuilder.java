package lombok.patcher.scripts;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/ScriptBuilder$AddFieldBuilder.SCL.lombok */
public class ScriptBuilder$AddFieldBuilder {
    private int accessFlags;
    private List<String> targetClasses = new ArrayList();
    private String fieldName;
    private String fieldType;
    private Object value;
    private static final int NO_ACCESS_LEVELS = -4;

    public AddFieldScript build() {
        if (this.targetClasses.isEmpty()) {
            throw new IllegalStateException("You have to set at least one targetClass.");
        }
        if (this.fieldName == null) {
            throw new IllegalStateException("You have to set a fieldName");
        }
        if (this.fieldType == null) {
            throw new IllegalStateException("You have to set the new field's type by calling fieldType");
        }
        if (this.value != null) {
            setStatic();
            setFinal();
        }
        return new AddFieldScript(this.targetClasses, this.accessFlags, this.fieldName, this.fieldType, this.value);
    }

    public ScriptBuilder$AddFieldBuilder targetClass(String targetClass) {
        ScriptBuilder.access$0(targetClass);
        this.targetClasses.add(targetClass);
        return this;
    }

    public ScriptBuilder$AddFieldBuilder value(Object value) {
        this.value = value;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder fieldName(String fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder fieldType(String fieldType) {
        ScriptBuilder.access$1(fieldType);
        this.fieldType = fieldType;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setPublic() {
        this.accessFlags = (this.accessFlags & (-4)) | 1;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setPrivate() {
        this.accessFlags = (this.accessFlags & (-4)) | 2;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setProtected() {
        this.accessFlags = (this.accessFlags & (-4)) | 4;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setPackageAccess() {
        this.accessFlags &= -4;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setStatic() {
        this.accessFlags |= 8;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setFinal() {
        this.accessFlags |= 16;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setVolatile() {
        this.accessFlags |= 64;
        return this;
    }

    public ScriptBuilder$AddFieldBuilder setTransient() {
        this.accessFlags |= 128;
        return this;
    }
}
