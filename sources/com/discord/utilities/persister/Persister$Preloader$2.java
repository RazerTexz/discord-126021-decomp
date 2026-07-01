package com.discord.utilities.persister;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Persister.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class Persister$Preloader$2 extends o implements Function1<Persister<?>, Unit> {
    public final /* synthetic */ Persister$Preloader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Persister$Preloader$2(Persister$Preloader persister$Preloader) {
        super(1);
        this.this$0 = persister$Preloader;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Persister<?> persister) {
        invoke2(persister);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Persister<?> persister) {
        if (persister != null) {
            Persister$Preloader.access$handlePreload(this.this$0, persister);
        }
    }
}
