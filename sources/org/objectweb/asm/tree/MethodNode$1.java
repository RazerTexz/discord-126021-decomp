package org.objectweb.asm.tree;

import java.util.ArrayList;

/* JADX INFO: loaded from: app.apk:org/objectweb/asm/tree/MethodNode$1.SCL.lombok */
class MethodNode$1 extends ArrayList<Object> {
    final /* synthetic */ MethodNode this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MethodNode$1(MethodNode this$0, int x0) {
        super(x0);
        this.this$0 = this$0;
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object o) {
        this.this$0.annotationDefault = o;
        return super.add(o);
    }
}
