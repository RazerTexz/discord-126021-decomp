package org.objectweb.asm.tree;

import java.util.Map;
import org.objectweb.asm.MethodVisitor;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/tree/MethodInsnNode.SCL.lombok */
public class MethodInsnNode extends AbstractInsnNode {
    public String owner;
    public String name;
    public String desc;
    public boolean itf;

    public MethodInsnNode(int opcode, String owner, String name, String descriptor) {
        this(opcode, owner, name, descriptor, opcode == 185);
    }

    public MethodInsnNode(int opcode, String owner, String name, String descriptor, boolean isInterface) {
        super(opcode);
        this.owner = owner;
        this.name = name;
        this.desc = descriptor;
        this.itf = isInterface;
    }

    public void setOpcode(int opcode) {
        this.opcode = opcode;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public int getType() {
        return 5;
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public void accept(MethodVisitor methodVisitor) {
        methodVisitor.visitMethodInsn(this.opcode, this.owner, this.name, this.desc, this.itf);
        acceptAnnotations(methodVisitor);
    }

    @Override // org.objectweb.asm.tree.AbstractInsnNode
    public AbstractInsnNode clone(Map<LabelNode, LabelNode> clonedLabels) {
        return new MethodInsnNode(this.opcode, this.owner, this.name, this.desc, this.itf).cloneAnnotations(this);
    }
}
