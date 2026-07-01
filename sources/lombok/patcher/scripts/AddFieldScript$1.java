package lombok.patcher.scripts;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.FieldVisitor;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/AddFieldScript$1.SCL.lombok */
class AddFieldScript$1 extends ClassVisitor {
    private boolean alreadyAdded;
    final /* synthetic */ AddFieldScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AddFieldScript$1(AddFieldScript addFieldScript, int $anonymous0, ClassVisitor $anonymous1) {
        super($anonymous0, $anonymous1);
        this.this$0 = addFieldScript;
        this.alreadyAdded = false;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public FieldVisitor visitField(int access, String name, String desc, String signature, Object value) {
        if (name != null && name.equals(AddFieldScript.access$0(this.this$0))) {
            this.alreadyAdded = true;
        }
        return super.visitField(access, name, desc, signature, value);
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitEnd() {
        if (!this.alreadyAdded) {
            FieldVisitor fv = this.cv.visitField(AddFieldScript.access$1(this.this$0), AddFieldScript.access$0(this.this$0), AddFieldScript.access$2(this.this$0), null, AddFieldScript.access$3(this.this$0));
            fv.visitEnd();
        }
        super.visitEnd();
    }
}
