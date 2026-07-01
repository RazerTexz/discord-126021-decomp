package com.discord.views;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.MainThread;
import androidx.annotation.Px;
import b.a.i.ViewVoiceUserBinding;
import b.a.y.VoiceUserView2;
import b.a.y.VoiceUserView3;
import b.a.y.VoiceUserView4;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.anim.RingAnimator;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int defaultVoiceStateBackground;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final ViewVoiceUserBinding binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public a displayVoiceState;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final RingAnimator ringAnimator;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public StoreVoiceParticipants.VoiceUser voiceUser;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onBitmapLoadedListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String prevAvatarUrl;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean fadeWhenDisconnected;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean animateAvatarWhenRinging;

    /* JADX INFO: compiled from: VoiceUserView.kt */
    public enum a {
        CONNECTED,
        SPEAKING,
        MUTED,
        RINGING,
        DISCONNECTED
    }

    /* JADX INFO: compiled from: VoiceUserView.kt */
    public static final class b extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ int $avatarSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(int i) {
            super(1);
            this.$avatarSize = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "$this$resizeLayoutParams");
            if (view.getLayoutParams().width == this.$avatarSize && view.getLayoutParams().height == this.$avatarSize) {
                return;
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int i = this.$avatarSize;
            layoutParams.width = i;
            layoutParams.height = i;
            view.setLayoutParams(layoutParams);
        }
    }

    /* JADX INFO: compiled from: VoiceUserView.kt */
    public static final class c extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $newAvatarUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.$newAvatarUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            Intrinsics3.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.l = new VoiceUserView4(this);
            return Unit.a;
        }
    }

    public VoiceUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VoiceUserView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        Intrinsics3.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        this.defaultVoiceStateBackground = R.color.transparent;
        LayoutInflater.from(context).inflate(com.discord.R.layout.view_voice_user, this);
        int i3 = com.discord.R.id.voice_user_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(com.discord.R.id.voice_user_avatar);
        if (simpleDraweeView != null) {
            i3 = com.discord.R.id.voice_user_name_display;
            TextView textView = (TextView) findViewById(com.discord.R.id.voice_user_name_display);
            if (textView != null) {
                ViewVoiceUserBinding viewVoiceUserBinding = new ViewVoiceUserBinding(this, simpleDraweeView, textView);
                Intrinsics3.checkNotNullExpressionValue(viewVoiceUserBinding, "ViewVoiceUserBinding.inf…ater.from(context), this)");
                this.binding = viewVoiceUserBinding;
                this.ringAnimator = new RingAnimator(this, new VoiceUserView3(this));
                this.onBitmapLoadedListener = VoiceUserView2.j;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, com.discord.R.a.VoiceUserView, 0, 0);
                    Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.VoiceUserView, 0, 0)");
                    int dimension = (int) typedArrayObtainStyledAttributes.getDimension(1, 0.0f);
                    boolean z2 = typedArrayObtainStyledAttributes.getBoolean(2, false);
                    boolean z3 = typedArrayObtainStyledAttributes.getBoolean(0, false);
                    typedArrayObtainStyledAttributes.recycle();
                    if (dimension > 0) {
                        setAvatarSize(dimension);
                    }
                    setFadeWhenDisconnected(z2);
                    setAnimateAvatarWhenRinging(z3);
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i3)));
    }

    private final void setVoiceState(StoreVoiceParticipants.VoiceUser voiceUser) {
        a aVar;
        VoiceState voiceState = voiceUser.getVoiceState();
        boolean z2 = voiceState != null && (voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress());
        if (voiceUser.getIsSpeaking()) {
            aVar = a.SPEAKING;
        } else if (voiceUser.isRinging()) {
            aVar = a.RINGING;
        } else if (voiceUser.isConnected()) {
            aVar = z2 ? a.MUTED : a.CONNECTED;
        } else {
            aVar = a.DISCONNECTED;
        }
        setVoiceState(aVar);
    }

    @MainThread
    public final void a(StoreVoiceParticipants.VoiceUser voiceUser, @DimenRes int sizeDimenRes) {
        Intrinsics3.checkNotNullParameter(voiceUser, "voiceUser");
        if (Intrinsics3.areEqual(this.voiceUser, voiceUser)) {
            return;
        }
        this.voiceUser = voiceUser;
        int dimensionPixelSize = getResources().getDimensionPixelSize(sizeDimenRes);
        Integer numValueOf = dimensionPixelSize > 0 ? Integer.valueOf(IconUtils.getMediaProxySize(dimensionPixelSize)) : null;
        GuildMember guildMember = voiceUser.getGuildMember();
        IconUtils iconUtils = IconUtils.INSTANCE;
        StoreVoiceParticipants.VoiceUser voiceUser2 = this.voiceUser;
        String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(iconUtils, voiceUser2 != null ? voiceUser2.getUser() : null, guildMember, numValueOf, false, 8, null);
        if (!Intrinsics3.areEqual(this.prevAvatarUrl, forGuildMemberOrUser$default)) {
            this.prevAvatarUrl = forGuildMemberOrUser$default;
            SimpleDraweeView simpleDraweeView = this.binding.f141b;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMemberOrUser$default, sizeDimenRes, new c(forGuildMemberOrUser$default), (MGImages.ChangeDetector) null, 16, (Object) null);
        }
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        textView.setText(voiceUser.getDisplayName());
        setVoiceState(voiceUser);
    }

    @MainThread
    public final void setAnimateAvatarWhenRinging(boolean animateAvatarWhenRinging) {
        this.animateAvatarWhenRinging = animateAvatarWhenRinging;
    }

    @MainThread
    public final void setAvatarSize(int avatarSize) {
        b bVar = new b(avatarSize);
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        bVar.invoke2((View) simpleDraweeView);
        TextView textView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        bVar.invoke2((View) textView);
        requestLayout();
    }

    public final void setDefaultVoiceStateBackground(int resource) {
        this.defaultVoiceStateBackground = resource;
    }

    @MainThread
    public final void setFadeWhenDisconnected(boolean fadeWhenDisconnected) {
        this.fadeWhenDisconnected = fadeWhenDisconnected;
    }

    public final void setOnBitmapLoadedListener(Function2<? super Bitmap, ? super String, Unit> onBitmapLoadedListener) {
        Intrinsics3.checkNotNullParameter(onBitmapLoadedListener, "onBitmapLoadedListener");
        this.onBitmapLoadedListener = onBitmapLoadedListener;
    }

    @MainThread
    public final void setRingMargin(@Px int size) {
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        SimpleDraweeView simpleDraweeView2 = this.binding.f141b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.voiceUserAvatar");
        ViewGroup.LayoutParams layoutParams = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        layoutParams2.setMargins(size, size, size, size);
        simpleDraweeView.setLayoutParams(layoutParams2);
        requestLayout();
    }

    @Override // android.view.View
    public void setSelected(boolean selected) {
        boolean z2 = isSelected() != selected;
        super.setSelected(selected);
        if (z2) {
            ViewExtensions.fadeBy$default(this.binding.c, isSelected(), 0L, 2, null);
        }
    }

    @MainThread
    public final void setVoiceUser(StoreVoiceParticipants.VoiceUser voiceUser) {
        a(voiceUser, com.discord.R.dimen.avatar_size_unrestricted);
    }

    private final void setVoiceState(a displayVoiceState) {
        if (displayVoiceState == this.displayVoiceState) {
            return;
        }
        this.displayVoiceState = displayVoiceState;
        setBackgroundResource(displayVoiceState.ordinal() != 1 ? this.defaultVoiceStateBackground : com.discord.R.drawable.drawable_voice_user_background_speaking);
        float f = (displayVoiceState == a.DISCONNECTED && this.fadeWhenDisconnected) ? 0.3f : 1.0f;
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        simpleDraweeView.setAlpha(f);
        setAlpha(f);
        this.ringAnimator.onUpdate();
    }
}
