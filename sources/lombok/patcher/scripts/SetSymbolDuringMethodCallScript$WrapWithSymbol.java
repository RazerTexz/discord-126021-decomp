package lombok.patcher.scripts;

import java.util.List;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: app.apk:lombok/patcher/scripts/SetSymbolDuringMethodCallScript$WrapWithSymbol.SCL.lombok */
class SetSymbolDuringMethodCallScript$WrapWithSymbol extends MethodVisitor {
    private final String selfMethodName;
    private final String selfTypeName;
    private final List<WrapperMethodDescriptor> descriptors;
    final /* synthetic */ SetSymbolDuringMethodCallScript this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SetSymbolDuringMethodCallScript$WrapWithSymbol(SetSymbolDuringMethodCallScript setSymbolDuringMethodCallScript, String selfMethodName, MethodVisitor mv, String selfTypeName, List<WrapperMethodDescriptor> descriptors) {
        super(Opcodes.ASM7, mv);
        this.this$0 = setSymbolDuringMethodCallScript;
        this.selfMethodName = selfMethodName;
        this.selfTypeName = selfTypeName;
        this.descriptors = descriptors;
    }

    @Override // org.objectweb.asm.MethodVisitor
    public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
        boolean addOwner;
        String fixedDesc;
        if (opcode == 185 || opcode == 182) {
            addOwner = true;
        } else {
            if (opcode != 184) {
                super.visitMethodInsn(opcode, owner, name, desc, itf);
                return;
            }
            addOwner = false;
        }
        if (!SetSymbolDuringMethodCallScript.access$0(this.this$0).getClassSpec().equals(owner) || !SetSymbolDuringMethodCallScript.access$0(this.this$0).getMethodName().equals(name) || !SetSymbolDuringMethodCallScript.access$0(this.this$0).getMethodDescriptor().equals(desc)) {
            super.visitMethodInsn(opcode, owner, name, desc, itf);
            return;
        }
        if (addOwner) {
            fixedDesc = "(L" + SetSymbolDuringMethodCallScript.access$0(this.this$0).getClassSpec() + ";" + desc.substring(1);
        } else {
            fixedDesc = desc;
        }
        WrapperMethodDescriptor wmd = new WrapperMethodDescriptor(this.descriptors.size(), opcode, owner, name, fixedDesc, desc, itf);
        if (SetSymbolDuringMethodCallScript.access$1(this.this$0)) {
            System.out.println("Changing method " + this.selfTypeName + "::" + this.selfMethodName + " wrapping call to " + owner + "::" + name + " to set symbol " + SetSymbolDuringMethodCallScript.access$2(this.this$0));
        }
        super.visitMethodInsn(Opcodes.INVOKESTATIC, this.selfTypeName, wmd.getWrapperName(), fixedDesc, false);
        this.descriptors.add(wmd);
    }
}
