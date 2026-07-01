package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import b.i.c.m.d.k.CommonUtils;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1<T> extends Lambda implements Function2<SelectionAggregator<T>, T, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ SelectionAggregator $aggregator;
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SelectionAggregator selectionAggregator, Attachment attachment) {
            super(0);
            this.$aggregator = selectionAggregator;
            this.$attachment = attachment;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$aggregator.unselectItem(this.$attachment);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public final /* synthetic */ SelectionAggregator $aggregator;
        public final /* synthetic */ Attachment $attachment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Attachment attachment, SelectionAggregator selectionAggregator) {
            super(1);
            this.$attachment = attachment;
            this.$aggregator = selectionAggregator;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            this.$attachment.setSpoiler(z2);
            this.$aggregator.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1(WidgetChatInputAttachments widgetChatInputAttachments) {
        super(2);
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((SelectionAggregator) obj, (Attachment) obj2);
        return Unit.a;
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/lytefast/flexinput/utils/SelectionAggregator<TT;>;TT;)V */
    public final void invoke(SelectionAggregator selectionAggregator, Attachment attachment) {
        Intrinsics3.checkNotNullParameter(selectionAggregator, "aggregator");
        Intrinsics3.checkNotNullParameter(attachment, "attachment");
        CommonUtils.r(this.this$0.flexInputFragment.requireContext(), this.this$0.flexInputFragment.l());
        AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = this.this$0.flexInputFragment.getChildFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
        AttachmentBottomSheet.Companion.show$default(companion, childFragmentManager, attachment, new AnonymousClass1(selectionAggregator, attachment), new AnonymousClass2(attachment, selectionAggregator), null, 16, null);
    }
}
