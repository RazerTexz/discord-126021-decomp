package com.discord.views;

import android.R$integer;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.Configuration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.RecyclerView;
import b.a.i.y0;
import b.a.y.l;
import b.a.y.n;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.z.d.m;
import defpackage.p;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog extends l implements AppComponent {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final SimpleRecyclerAdapter<StoreVoiceParticipants$VoiceUser, OverlayMenuBubbleDialog$a> adapter;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final y0 binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuBubbleDialog(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R$layout.overlay_bubble_menu, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.overlay_header;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R$id.overlay_header);
        if (linearLayout != null) {
            i = R$id.overlay_linked_anchor_view;
            View viewFindViewById = viewInflate.findViewById(R$id.overlay_linked_anchor_view);
            if (viewFindViewById != null) {
                i = R$id.overlay_members_overflow_tv;
                TextView textView = (TextView) viewInflate.findViewById(R$id.overlay_members_overflow_tv);
                if (textView != null) {
                    i = R$id.overlay_members_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R$id.overlay_members_rv);
                    if (recyclerView != null) {
                        i = R$id.overlay_menu;
                        OverlayMenuView overlayMenuView = (OverlayMenuView) viewInflate.findViewById(R$id.overlay_menu);
                        if (overlayMenuView != null) {
                            y0 y0Var = new y0((LinearLayout) viewInflate, linearLayout, viewFindViewById, textView, recyclerView, overlayMenuView);
                            m.checkNotNullExpressionValue(y0Var, "OverlayBubbleMenuBinding…rom(context), this, true)");
                            this.binding = y0Var;
                            this.adapter = new SimpleRecyclerAdapter<>(null, n.j, 1, null);
                            overlayMenuView.setOnDismissRequested$app_productionGoogleRelease(new p(0, this));
                            setClipChildren(false);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    @Override // b.a.y.l
    public Animator getClosingAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(getResources().getInteger(R$integer.config_shortAnimTime));
        OverlayMenuView overlayMenuView = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView.getContext(), 2130837533);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), 2130837535);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        return animatorSet;
    }

    public final View getLinkedAnchorView() {
        View view = this.binding.c;
        m.checkNotNullExpressionValue(view, "binding.overlayLinkedAnchorView");
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OverlayMenuView overlayMenuView = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        overlayMenuView.setAlpha(0.0f);
        LinearLayout linearLayout = this.binding.f233b;
        m.checkNotNullExpressionValue(linearLayout, "binding.overlayHeader");
        linearLayout.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        OverlayMenuView overlayMenuView2 = this.binding.f;
        m.checkNotNullExpressionValue(overlayMenuView2, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView2.getContext(), 2130837534);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), 2130837532);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        animatorSet.setStartDelay(getResources().getInteger(R$integer.config_shortAnimTime));
        animatorSet.start();
        RecyclerView recyclerView = this.binding.e;
        m.checkNotNullExpressionValue(recyclerView, "binding.overlayMembersRv");
        recyclerView.setAdapter(this.adapter);
        Observable observableG = StoreStream.Companion.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(OverlayMenuBubbleDialog$b.j).G(OverlayMenuBubbleDialog$c.j);
        m.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…- 3\n          }\n        }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), OverlayMenuBubbleDialog.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new OverlayMenuBubbleDialog$d(this), 62, (Object) null);
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getOnDialogClosed().invoke(this);
    }
}
