package com.discord.widgets.emoji;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.widgets.emoji.WidgetEmojiSheet;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetEmojiSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1 extends AbstractC12240o implements Function1<FragmentActivity, Boolean> {
    public final /* synthetic */ EmojiNode.EmojiIdAndType $emojiIdAndType;
    public final /* synthetic */ String $noticeName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiSheet$Companion$enqueueNotice$showEmojiSheetNotice$1(EmojiNode.EmojiIdAndType emojiIdAndType, String str) {
        super(1);
        this.$emojiIdAndType = emojiIdAndType;
        this.$noticeName = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(FragmentActivity fragmentActivity) {
        return Boolean.valueOf(invoke2(fragmentActivity));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(FragmentActivity fragmentActivity) {
        C12238m.checkNotNullParameter(fragmentActivity, "fragmentActivity");
        WidgetEmojiSheet.Companion companion = WidgetEmojiSheet.INSTANCE;
        FragmentManager supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        C12238m.checkNotNullExpressionValue(supportFragmentManager, "fragmentActivity.supportFragmentManager");
        companion.show(supportFragmentManager, this.$emojiIdAndType);
        StoreNotices.markSeen$default(StoreStream.INSTANCE.getNotices(), this.$noticeName, 0L, 2, null);
        return true;
    }
}
