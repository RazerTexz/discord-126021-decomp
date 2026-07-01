package com.discord.utilities.voice;

import android.graphics.Rect;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import b.a.y.w;
import com.discord.overlay.views.OverlayBubbleWrap;
import com.discord.views.OverlayMenuBubbleDialog;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: DiscordOverlayService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DiscordOverlayService$createVoiceBubble$1 extends o implements Function1<OverlayBubbleWrap, OverlayBubbleWrap> {
    public final /* synthetic */ String $anchorTag;
    public final /* synthetic */ DiscordOverlayService this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DiscordOverlayService$createVoiceBubble$1(DiscordOverlayService discordOverlayService, String str) {
        super(1);
        this.this$0 = discordOverlayService;
        this.$anchorTag = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ OverlayBubbleWrap invoke(OverlayBubbleWrap overlayBubbleWrap) {
        return invoke2(overlayBubbleWrap);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final OverlayBubbleWrap invoke2(OverlayBubbleWrap overlayBubbleWrap) {
        Rect rect;
        SimpleDraweeView imageView$app_productionGoogleRelease;
        m.checkNotNullParameter(overlayBubbleWrap, "srcBubble");
        OverlayMenuBubbleDialog overlayMenuBubbleDialogAccess$createMenu = DiscordOverlayService.access$createMenu(this.this$0);
        w wVar = (w) (!(overlayBubbleWrap instanceof w) ? null : overlayBubbleWrap);
        if (wVar == null || (imageView$app_productionGoogleRelease = wVar.getImageView$app_productionGoogleRelease()) == null) {
            rect = new Rect();
        } else {
            ViewGroup$LayoutParams layoutParams = imageView$app_productionGoogleRelease.getLayoutParams();
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = layoutParams instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams : null;
            int i = viewGroup$MarginLayoutParams == null ? 0 : viewGroup$MarginLayoutParams.leftMargin;
            ViewGroup$LayoutParams layoutParams2 = imageView$app_productionGoogleRelease.getLayoutParams();
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams2 = layoutParams2 instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams2 : null;
            int i2 = viewGroup$MarginLayoutParams2 == null ? 0 : viewGroup$MarginLayoutParams2.topMargin;
            ViewGroup$LayoutParams layoutParams3 = imageView$app_productionGoogleRelease.getLayoutParams();
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams3 = layoutParams3 instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams3 : null;
            int i3 = viewGroup$MarginLayoutParams3 == null ? 0 : viewGroup$MarginLayoutParams3.rightMargin;
            ViewGroup$LayoutParams layoutParams4 = imageView$app_productionGoogleRelease.getLayoutParams();
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams4 = layoutParams4 instanceof ViewGroup$MarginLayoutParams ? (ViewGroup$MarginLayoutParams) layoutParams4 : null;
            rect = new Rect(i, i2, i3, viewGroup$MarginLayoutParams4 != null ? viewGroup$MarginLayoutParams4.bottomMargin : 0);
        }
        ViewGroup$LayoutParams layoutParams5 = overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().getLayoutParams();
        layoutParams5.width = (overlayBubbleWrap.getWidth() - rect.left) - rect.right;
        layoutParams5.height = overlayBubbleWrap.getHeight();
        overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().requestLayout();
        overlayMenuBubbleDialogAccess$createMenu.getLinkedAnchorView().setTag(this.$anchorTag);
        return overlayMenuBubbleDialogAccess$createMenu;
    }
}
