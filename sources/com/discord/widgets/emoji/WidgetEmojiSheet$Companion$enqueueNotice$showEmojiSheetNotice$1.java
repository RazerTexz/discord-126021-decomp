package com.discord.widgets.emoji;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.EmojiNode$EmojiIdAndType;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1 extends o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ EmojiNode$EmojiIdAndType $emojiIdAndType;
    public final /* synthetic */ String $noticeName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1(EmojiNode$EmojiIdAndType emojiNode$EmojiIdAndType, String str) {
        super(1);
        this.$emojiIdAndType = emojiNode$EmojiIdAndType;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetEmojiSheet$Companion widgetEmojiSheet$Companion = WidgetEmojiSheet.Companion;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        widgetEmojiSheet$Companion.show(supportFragmentManager, this.$emojiIdAndType);
        StoreNotices.markSeen$default(StoreStream.Companion.getNotices(), this.$noticeName, 0L, 2, null);
        return true;
    }
}
