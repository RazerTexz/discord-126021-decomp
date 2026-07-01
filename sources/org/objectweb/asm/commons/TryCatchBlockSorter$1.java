package org.objectweb.asm.commons;

import java.util.Comparator;
import org.objectweb.asm.tree.TryCatchBlockNode;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/commons/TryCatchBlockSorter$1.SCL.lombok */
class TryCatchBlockSorter$1 implements Comparator<TryCatchBlockNode> {
    final /* synthetic */ TryCatchBlockSorter this$0;

    TryCatchBlockSorter$1(TryCatchBlockSorter this$0) {
        this.this$0 = this$0;
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(TryCatchBlockNode tryCatchBlockNode, TryCatchBlockNode tryCatchBlockNode2) {
        return compare2(tryCatchBlockNode, tryCatchBlockNode2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(TryCatchBlockNode tryCatchBlockNode1, TryCatchBlockNode tryCatchBlockNode2) {
        return blockLength(tryCatchBlockNode1) - blockLength(tryCatchBlockNode2);
    }

    private int blockLength(TryCatchBlockNode tryCatchBlockNode) {
        int startIndex = this.this$0.instructions.indexOf(tryCatchBlockNode.start);
        int endIndex = this.this$0.instructions.indexOf(tryCatchBlockNode.end);
        return endIndex - startIndex;
    }
}
