package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.Handle;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/InvokeDynamicInsnNode.SCL.lombok */
public class InvokeDynamicInsnNode extends AbstractInsnNode {
    public String name;
    public String desc;
    public Handle bsm;
    public Object[] bsmArgs;

    public InvokeDynamicInsnNode(String name, String descriptor, Handle bootstrapMethodHandle, Object... bootstrapMethodArguments) {
        super(Opcodes.INVOKEDYNAMIC);
        this.name = name;
        this.desc = descriptor;
        this.bsm = bootstrapMethodHandle;
        this.bsmArgs = bootstrapMethodArguments;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 6;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitInvokeDynamicInsn(this.name, this.desc, this.bsm, this.bsmArgs);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new InvokeDynamicInsnNode(this.name, this.desc, this.bsm, this.bsmArgs).cloneAnnotations(this);
    }
}
