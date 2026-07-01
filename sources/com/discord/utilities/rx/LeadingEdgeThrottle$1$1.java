package com.discord.utilities.rx;

import rx.functions.Action0;

/* JADX INFO: loaded from: classes2.dex */
public class LeadingEdgeThrottle$1$1 implements Action0 {
    public final /* synthetic */ LeadingEdgeThrottle$1 this$1;
    public final /* synthetic */ int val$index;

    public LeadingEdgeThrottle$1$1(LeadingEdgeThrottle$1 leadingEdgeThrottle$1, int i) {
        this.this$1 = leadingEdgeThrottle$1;
        this.val$index = i;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // rx.functions.Action0
    public void call() {
        LeadingEdgeThrottle$1 leadingEdgeThrottle$1 = this.this$1;
        leadingEdgeThrottle$1.state.emit(this.val$index, leadingEdgeThrottle$1.val$s, leadingEdgeThrottle$1.self);
    }
}
