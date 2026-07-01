package org.objectweb.asm.commons;

import java.util.Collections;
import java.util.Comparator;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.TryCatchBlockNode;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/TryCatchBlockSorter.SCL.lombok */
public class TryCatchBlockSorter extends MethodNode {
    public TryCatchBlockSorter(MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        this(Opcodes.ASM9, methodVisitor, access, name, descriptor, signature, exceptions);
        if (getClass() != TryCatchBlockSorter.class) {
            throw new IllegalStateException();
        }
    }

    protected TryCatchBlockSorter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor, String signature, String[] exceptions) {
        super(api, access, name, descriptor, signature, exceptions);
        this.mv = methodVisitor;
    }

    @Override // org.objectweb.asm.tree.MethodNode, org.objectweb.asm.MethodVisitor
    public void visitEnd() {
        Collections.sort(this.tryCatchBlocks, new Comparator<TryCatchBlockNode>() { // from class: org.objectweb.asm.commons.TryCatchBlockSorter.1
            @Override // java.util.Comparator
            public int compare(TryCatchBlockNode tryCatchBlockNode1, TryCatchBlockNode tryCatchBlockNode2) {
                return blockLength(tryCatchBlockNode1) - blockLength(tryCatchBlockNode2);
            }

            private int blockLength(TryCatchBlockNode tryCatchBlockNode) {
                int startIndex = TryCatchBlockSorter.this.instructions.indexOf(tryCatchBlockNode.start);
                int endIndex = TryCatchBlockSorter.this.instructions.indexOf(tryCatchBlockNode.end);
                return endIndex - startIndex;
            }
        });
        for (int i = 0; i < this.tryCatchBlocks.size(); i++) {
            this.tryCatchBlocks.get(i).updateIndex(i);
        }
        if (this.mv != null) {
            accept(this.mv);
        }
    }
}
