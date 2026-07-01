package com.discord.widgets.forums;

import d0.z.d.o;
import java.util.Comparator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserItem$Companion$postItemComparatorByMostRecent$2 extends o implements Function0<Comparator<ForumBrowserItem$PostItem>> {
    public static final ForumBrowserItem$Companion$postItemComparatorByMostRecent$2 INSTANCE = new ForumBrowserItem$Companion$postItemComparatorByMostRecent$2();

    public ForumBrowserItem$Companion$postItemComparatorByMostRecent$2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Comparator<ForumBrowserItem$PostItem> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Comparator<ForumBrowserItem$PostItem> invoke2() {
        return ForumBrowserItem$Companion$postItemComparatorByMostRecent$2$1.INSTANCE;
    }
}
