package com.discord.widgets.settings.premium;

import android.view.View;
import com.discord.i18n.RenderContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4 extends AbstractC12240o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ WidgetSettingsGiftingAdapter.GiftItem $data;
    public final /* synthetic */ WidgetSettingsGiftingAdapter.EntitlementListItem this$0;

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4$1 */
    /* JADX INFO: compiled from: WidgetSettingsGiftingAdapter.kt */
    public static final class C99191 extends AbstractC12240o implements Function1<View, Unit> {
        public C99191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            WidgetSettingsGiftingAdapter.EntitlementListItem.access$getAdapter$p(WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4.this.this$0).onRevokeClickListener.invoke(WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4.this.$data.getGift());
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSettingsGiftingAdapter$EntitlementListItem$onConfigure$4(WidgetSettingsGiftingAdapter.EntitlementListItem entitlementListItem, WidgetSettingsGiftingAdapter.GiftItem giftItem) {
        super(1);
        this.this$0 = entitlementListItem;
        this.$data = giftItem;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        C12238m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.m8423b("revokeHook", new C99191());
    }
}
