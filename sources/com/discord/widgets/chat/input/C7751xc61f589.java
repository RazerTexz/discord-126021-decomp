package com.discord.widgets.chat.input;

import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentManager;
import com.discord.widgets.chat.input.attachments.AttachmentBottomSheet;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p225i.p361c.p369m.p370d.p373k.C4628h;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1 */
/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7751xc61f589<T> extends AbstractC12240o implements Function2<SelectionAggregator<T>, T, Unit> {
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
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
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$aggregator.unselectItem(this.$attachment);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.chat.input.WidgetChatInputAttachments$createPreviewAdapter$onAttachmentSelected$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
    public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Boolean, Unit> {
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
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            this.$attachment.setSpoiler(z2);
            this.$aggregator.getAdapter().notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C7751xc61f589(WidgetChatInputAttachments widgetChatInputAttachments) {
        super(2);
        this.this$0 = widgetChatInputAttachments;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Object obj, Object obj2) {
        invoke((SelectionAggregator) obj, (Attachment) obj2);
        return Unit.f27425a;
    }

    /* JADX WARN: Incorrect types in method signature: (Lcom/lytefast/flexinput/utils/SelectionAggregator<TT;>;TT;)V */
    public final void invoke(SelectionAggregator selectionAggregator, Attachment attachment) {
        C12238m.checkNotNullParameter(selectionAggregator, "aggregator");
        C12238m.checkNotNullParameter(attachment, "attachment");
        C4628h.m6424r(this.this$0.flexInputFragment.requireContext(), this.this$0.flexInputFragment.m9293l());
        AttachmentBottomSheet.Companion companion = AttachmentBottomSheet.INSTANCE;
        FragmentManager childFragmentManager = this.this$0.flexInputFragment.getChildFragmentManager();
        C12238m.checkNotNullExpressionValue(childFragmentManager, "flexInputFragment.childFragmentManager");
        AttachmentBottomSheet.Companion.show$default(companion, childFragmentManager, attachment, new AnonymousClass1(selectionAggregator, attachment), new AnonymousClass2(attachment, selectionAggregator), null, 16, null);
    }
}
