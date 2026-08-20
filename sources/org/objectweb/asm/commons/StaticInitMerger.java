package org.objectweb.asm.commons;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

/* JADX INFO: loaded from: discord-126021.apk:org/objectweb/asm/commons/StaticInitMerger.SCL.lombok */
public class StaticInitMerger extends ClassVisitor {
    private String owner;
    private final String renamedClinitMethodPrefix;
    private int numClinitMethods;
    private MethodVisitor mergedClinitVisitor;

    public StaticInitMerger(String prefix, ClassVisitor classVisitor) {
        this(Opcodes.ASM9, prefix, classVisitor);
    }

    protected StaticInitMerger(int api, String prefix, ClassVisitor classVisitor) {
        super(api, classVisitor);
        this.renamedClinitMethodPrefix = prefix;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
        super.visit(version, access, name, signature, superName, interfaces);
        this.owner = name;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        MethodVisitor methodVisitor;
        if ("<clinit>".equals(name)) {
            StringBuilder sbAppend = new StringBuilder().append(this.renamedClinitMethodPrefix);
            int i = this.numClinitMethods;
            this.numClinitMethods = i + 1;
            String newName = sbAppend.append(i).toString();
            methodVisitor = super.visitMethod(10, newName, descriptor, signature, exceptions);
            if (this.mergedClinitVisitor == null) {
                this.mergedClinitVisitor = super.visitMethod(10, name, descriptor, null, null);
            }
            this.mergedClinitVisitor.visitMethodInsn(Opcodes.INVOKESTATIC, this.owner, newName, descriptor, false);
        } else {
            methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        }
        return methodVisitor;
    }

    @Override // org.objectweb.asm.ClassVisitor
    public void visitEnd() {
        if (this.mergedClinitVisitor != null) {
            this.mergedClinitVisitor.visitInsn(Opcodes.RETURN);
            this.mergedClinitVisitor.visitMaxs(0, 0);
        }
        super.visitEnd();
    }
}
