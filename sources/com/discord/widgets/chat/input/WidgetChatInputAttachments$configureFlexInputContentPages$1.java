package com.discord.widgets.chat.input;

import android.content.Context;
import b.b.a.d.d$a;
import com.discord.R$attr;
import com.discord.R$string;
import com.discord.utilities.drawable.DrawableCompat;
import com.lytefast.flexinput.fragment.FlexInputFragment;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatInputAttachments.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAttachments$configureFlexInputContentPages$1 extends o implements Function0<Unit> {
    public final /* synthetic */ boolean $canCreateThread;
    public final /* synthetic */ WidgetChatInputAttachments this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAttachments$configureFlexInputContentPages$1(WidgetChatInputAttachments widgetChatInputAttachments, boolean z2) {
        super(0);
        this.this$0 = widgetChatInputAttachments;
        this.$canCreateThread = z2;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Context contextRequireContext = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0).requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "flexInputFragment.requireContext()");
        List listMutableListOf = n.mutableListOf(new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$1(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$attr.ic_flex_input_image, 0, 2, (Object) null), R$string.attachment_media), new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$2(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$attr.ic_flex_input_file, 0, 2, (Object) null), R$string.attachment_files), new WidgetChatInputAttachments$configureFlexInputContentPages$1$pageArray$3(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, R$attr.ic_flex_input_add_a_photo, 0, 2, (Object) null), R$string.camera));
        if (this.$canCreateThread) {
            listMutableListOf.add(new WidgetChatInputAttachments$configureFlexInputContentPages$1$page$1(contextRequireContext, DrawableCompat.getThemedDrawableRes$default(contextRequireContext, 2130969495, 0, 2, (Object) null), 2131888265));
        }
        FlexInputFragment flexInputFragmentAccess$getFlexInputFragment$p = WidgetChatInputAttachments.access$getFlexInputFragment$p(this.this$0);
        Object[] array = listMutableListOf.toArray(new d$a[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        d$a[] d_aArr = (d$a[]) array;
        Objects.requireNonNull(flexInputFragmentAccess$getFlexInputFragment$p);
        m.checkNotNullParameter(d_aArr, "pageSuppliers");
        flexInputFragmentAccess$getFlexInputFragment$p.r = d_aArr;
        Iterator<Function0<Unit>> it = flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.iterator();
        while (it.hasNext()) {
            it.next().invoke();
        }
        flexInputFragmentAccess$getFlexInputFragment$p.onContentPagesInitializedUpdates.clear();
    }
}
