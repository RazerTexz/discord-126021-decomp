package com.discord.views;

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
import b.a.i.OverlayBubbleMenuBinding;
import b.a.i.OverlayMenuVoiceMembersItemBinding;
import b.a.y.OverlayAppDialog2;
import b.a.y.OverlayMenuBubbleDialog2;
import b.a.y.OverlayMenuBubbleDialog4;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppComponent;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.views.SimpleRecyclerAdapter;
import d0.Tuples;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import defpackage.p;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.List;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OverlayMenuBubbleDialog extends OverlayAppDialog2 implements AppComponent {

    /* JADX INFO: renamed from: A, reason: from kotlin metadata */
    public final SimpleRecyclerAdapter<StoreVoiceParticipants.VoiceUser, a> adapter;

    /* JADX INFO: renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final OverlayBubbleMenuBinding binding;

    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class a extends SimpleRecyclerAdapter.ViewHolder<StoreVoiceParticipants.VoiceUser> {
        public final OverlayMenuVoiceMembersItemBinding a;

        /* JADX WARN: Illegal instructions before constructor call */
        public a(OverlayMenuVoiceMembersItemBinding overlayMenuVoiceMembersItemBinding) {
            Intrinsics3.checkNotNullParameter(overlayMenuVoiceMembersItemBinding, "binding");
            VoiceUserView voiceUserView = overlayMenuVoiceMembersItemBinding.a;
            Intrinsics3.checkNotNullExpressionValue(voiceUserView, "binding.root");
            super(voiceUserView);
            this.a = overlayMenuVoiceMembersItemBinding;
        }

        @Override // com.discord.utilities.views.SimpleRecyclerAdapter.ViewHolder
        public void bind(StoreVoiceParticipants.VoiceUser voiceUser) {
            StoreVoiceParticipants.VoiceUser voiceUser2 = voiceUser;
            Intrinsics3.checkNotNullParameter(voiceUser2, "data");
            this.a.a.a(voiceUser2, R.dimen.avatar_size_extra_large);
        }
    }

    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class b<T, R> implements Func1<Long, Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>>> {
        public static final b j = new b();

        @Override // j0.k.Func1
        public Observable<? extends List<? extends StoreVoiceParticipants.VoiceUser>> call(Long l) {
            Long l2 = l;
            StoreChannels channels = StoreStream.INSTANCE.getChannels();
            Intrinsics3.checkNotNullExpressionValue(l2, "channelId");
            return channels.observeChannel(l2.longValue()).Y(new OverlayMenuBubbleDialog4(l2));
        }
    }

    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class c<T, R> implements Func1<List<? extends StoreVoiceParticipants.VoiceUser>, Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>> {
        public static final c j = new c();

        @Override // j0.k.Func1
        public Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> call(List<? extends StoreVoiceParticipants.VoiceUser> list) {
            List<? extends StoreVoiceParticipants.VoiceUser> list2 = list;
            ArrayList arrayListA0 = outline.a0(list2, "voiceUsers");
            for (T t : list2) {
                if (!((StoreVoiceParticipants.VoiceUser) t).isMe()) {
                    arrayListA0.add(t);
                }
            }
            int size = arrayListA0.size();
            return (size >= 0 && 3 >= size) ? Tuples.to(arrayListA0, 0) : Tuples.to(_Collections.take(arrayListA0, 3), Integer.valueOf(arrayListA0.size() - 3));
        }
    }

    /* JADX INFO: compiled from: OverlayMenuBubbleDialog.kt */
    public static final class d extends Lambda implements Function1<Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer>, Unit> {
        public d() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> tuples2) {
            String string;
            Tuples2<? extends List<? extends StoreVoiceParticipants.VoiceUser>, ? extends Integer> tuples3 = tuples2;
            List<? extends StoreVoiceParticipants.VoiceUser> listComponent1 = tuples3.component1();
            int iIntValue = tuples3.component2().intValue();
            OverlayMenuBubbleDialog overlayMenuBubbleDialog = OverlayMenuBubbleDialog.this;
            overlayMenuBubbleDialog.adapter.setData(listComponent1);
            if (iIntValue == 0) {
                string = null;
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append('+');
                sb.append(iIntValue);
                string = sb.toString();
            }
            TextView textView = overlayMenuBubbleDialog.binding.d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.overlayMembersOverflowTv");
            ViewExtensions.setTextAndVisibilityBy(textView, string);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayMenuBubbleDialog(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        View viewInflate = LayoutInflater.from(getContext()).inflate(R.layout.overlay_bubble_menu, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.overlay_header;
        LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.overlay_header);
        if (linearLayout != null) {
            i = R.id.overlay_linked_anchor_view;
            View viewFindViewById = viewInflate.findViewById(R.id.overlay_linked_anchor_view);
            if (viewFindViewById != null) {
                i = R.id.overlay_members_overflow_tv;
                TextView textView = (TextView) viewInflate.findViewById(R.id.overlay_members_overflow_tv);
                if (textView != null) {
                    i = R.id.overlay_members_rv;
                    RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.overlay_members_rv);
                    if (recyclerView != null) {
                        i = R.id.overlay_menu;
                        OverlayMenuView overlayMenuView = (OverlayMenuView) viewInflate.findViewById(R.id.overlay_menu);
                        if (overlayMenuView != null) {
                            OverlayBubbleMenuBinding overlayBubbleMenuBinding = new OverlayBubbleMenuBinding((LinearLayout) viewInflate, linearLayout, viewFindViewById, textView, recyclerView, overlayMenuView);
                            Intrinsics3.checkNotNullExpressionValue(overlayBubbleMenuBinding, "OverlayBubbleMenuBinding…rom(context), this, true)");
                            this.binding = overlayBubbleMenuBinding;
                            this.adapter = new SimpleRecyclerAdapter<>(null, OverlayMenuBubbleDialog2.j, 1, null);
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

    @Override // b.a.y.OverlayAppDialog2
    public Animator getClosingAnimator() {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(getResources().getInteger(android.R.integer.config_shortAnimTime));
        OverlayMenuView overlayMenuView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView.getContext(), R.animator.overlay_slide_down_fade_out);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_up_fade_out);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        return animatorSet;
    }

    public final View getLinkedAnchorView() {
        View view = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.overlayLinkedAnchorView");
        return view;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OverlayMenuView overlayMenuView = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView, "binding.overlayMenu");
        overlayMenuView.setAlpha(0.0f);
        LinearLayout linearLayout = this.binding.f233b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.overlayHeader");
        linearLayout.setAlpha(0.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        OverlayMenuView overlayMenuView2 = this.binding.f;
        Intrinsics3.checkNotNullExpressionValue(overlayMenuView2, "binding.overlayMenu");
        Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(overlayMenuView2.getContext(), R.animator.overlay_slide_up_fade_in);
        animatorLoadAnimator.setTarget(this.binding.f);
        Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R.animator.overlay_slide_down_fade_in);
        animatorLoadAnimator2.setTarget(this.binding.f233b);
        animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
        animatorSet.setStartDelay(getResources().getInteger(android.R.integer.config_shortAnimTime));
        animatorSet.start();
        RecyclerView recyclerView = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.overlayMembersRv");
        recyclerView.setAdapter(this.adapter);
        Observable observableG = StoreStream.INSTANCE.getVoiceChannelSelected().observeSelectedVoiceChannelId().Y(b.j).G(c.j);
        Intrinsics3.checkNotNullExpressionValue(observableG, "StoreStream\n        .get…- 3\n          }\n        }");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableG), this, null, 2, null), (Class<?>) OverlayMenuBubbleDialog.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new d());
    }

    @Override // com.discord.overlay.views.OverlayDialog, com.discord.overlay.views.OverlayBubbleWrap, android.view.View
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        getOnDialogClosed().invoke(this);
    }
}
