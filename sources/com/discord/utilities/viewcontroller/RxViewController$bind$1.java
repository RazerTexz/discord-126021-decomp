package com.discord.utilities.viewcontroller;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RxViewController.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RxViewController$bind$1<T> extends o implements Function1<T, Unit> {
    public final /* synthetic */ RxViewController this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RxViewController$bind$1(RxViewController rxViewController) {
        super(1);
        this.this$0 = rxViewController;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t) {
        this.this$0.configureView(t);
    }
}
