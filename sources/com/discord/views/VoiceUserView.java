package com.discord.views;

import android.R$color;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.TextView;
import androidx.annotation.DimenRes;
import androidx.annotation.MainThread;
import androidx.annotation.Px;
import b.a.i.j4;
import b.a.y.g0;
import b.a.y.h0;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants$VoiceUser;
import com.discord.utilities.anim.RingAnimator;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView extends FrameLayout {
    public static final /* synthetic */ int j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int defaultVoiceStateBackground;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final j4 binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public VoiceUserView$a displayVoiceState;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public final RingAnimator ringAnimator;

    /* JADX INFO: renamed from: o, reason: from kotlin metadata */
    public StoreVoiceParticipants$VoiceUser voiceUser;

    /* JADX INFO: renamed from: p, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onBitmapLoadedListener;

    /* JADX INFO: renamed from: q, reason: from kotlin metadata */
    public String prevAvatarUrl;

    /* JADX INFO: renamed from: r, reason: from kotlin metadata */
    public boolean fadeWhenDisconnected;

    /* JADX INFO: renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean animateAvatarWhenRinging;

    public VoiceUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VoiceUserView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        m.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        this.defaultVoiceStateBackground = R$color.transparent;
        LayoutInflater.from(context).inflate(R$layout.view_voice_user, this);
        int i3 = R$id.voice_user_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.voice_user_avatar);
        if (simpleDraweeView != null) {
            i3 = R$id.voice_user_name_display;
            TextView textView = (TextView) findViewById(R$id.voice_user_name_display);
            if (textView != null) {
                j4 j4Var = new j4(this, simpleDraweeView, textView);
                m.checkNotNullExpressionValue(j4Var, "ViewVoiceUserBinding.inf…ater.from(context), this)");
                this.binding = j4Var;
                this.ringAnimator = new RingAnimator(this, new h0(this));
                this.onBitmapLoadedListener = g0.j;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.VoiceUserView, 0, 0);
                    m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.VoiceUserView, 0, 0)");
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

    private final void setVoiceState(StoreVoiceParticipants$VoiceUser voiceUser) {
        VoiceUserView$a voiceUserView$a;
        VoiceState voiceState = voiceUser.getVoiceState();
        boolean z2 = voiceState != null && (voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress());
        if (voiceUser.getIsSpeaking()) {
            voiceUserView$a = VoiceUserView$a.SPEAKING;
        } else if (voiceUser.isRinging()) {
            voiceUserView$a = VoiceUserView$a.RINGING;
        } else if (voiceUser.isConnected()) {
            voiceUserView$a = z2 ? VoiceUserView$a.MUTED : VoiceUserView$a.CONNECTED;
        } else {
            voiceUserView$a = VoiceUserView$a.DISCONNECTED;
        }
        setVoiceState(voiceUserView$a);
    }

    @MainThread
    public final void a(StoreVoiceParticipants$VoiceUser voiceUser, @DimenRes int sizeDimenRes) {
        m.checkNotNullParameter(voiceUser, "voiceUser");
        if (m.areEqual(this.voiceUser, voiceUser)) {
            return;
        }
        this.voiceUser = voiceUser;
        int dimensionPixelSize = getResources().getDimensionPixelSize(sizeDimenRes);
        Integer numValueOf = dimensionPixelSize > 0 ? Integer.valueOf(IconUtils.getMediaProxySize(dimensionPixelSize)) : null;
        GuildMember guildMember = voiceUser.getGuildMember();
        IconUtils iconUtils = IconUtils.INSTANCE;
        StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser = this.voiceUser;
        String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(iconUtils, storeVoiceParticipants$VoiceUser != null ? storeVoiceParticipants$VoiceUser.getUser() : null, guildMember, numValueOf, false, 8, null);
        if (!m.areEqual(this.prevAvatarUrl, forGuildMemberOrUser$default)) {
            this.prevAvatarUrl = forGuildMemberOrUser$default;
            SimpleDraweeView simpleDraweeView = this.binding.f141b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMemberOrUser$default, sizeDimenRes, new VoiceUserView$c(this, forGuildMemberOrUser$default), (MGImages$ChangeDetector) null, 16, (Object) null);
        }
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        textView.setText(voiceUser.getDisplayName());
        setVoiceState(voiceUser);
    }

    @MainThread
    public final void setAnimateAvatarWhenRinging(boolean animateAvatarWhenRinging) {
        this.animateAvatarWhenRinging = animateAvatarWhenRinging;
    }

    @MainThread
    public final void setAvatarSize(int avatarSize) {
        VoiceUserView$b voiceUserView$b = new VoiceUserView$b(avatarSize);
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        voiceUserView$b.invoke2((View) simpleDraweeView);
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        voiceUserView$b.invoke2((View) textView);
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
        m.checkNotNullParameter(onBitmapLoadedListener, "onBitmapLoadedListener");
        this.onBitmapLoadedListener = onBitmapLoadedListener;
    }

    @MainThread
    public final void setRingMargin(@Px int size) {
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        SimpleDraweeView simpleDraweeView2 = this.binding.f141b;
        m.checkNotNullExpressionValue(simpleDraweeView2, "binding.voiceUserAvatar");
        ViewGroup$LayoutParams layoutParams = simpleDraweeView2.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout$LayoutParams frameLayout$LayoutParams = (FrameLayout$LayoutParams) layoutParams;
        frameLayout$LayoutParams.setMargins(size, size, size, size);
        simpleDraweeView.setLayoutParams(frameLayout$LayoutParams);
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
    public final void setVoiceUser(StoreVoiceParticipants$VoiceUser storeVoiceParticipants$VoiceUser) {
        a(storeVoiceParticipants$VoiceUser, 2131165301);
    }

    private final void setVoiceState(VoiceUserView$a displayVoiceState) {
        if (displayVoiceState == this.displayVoiceState) {
            return;
        }
        this.displayVoiceState = displayVoiceState;
        setBackgroundResource(displayVoiceState.ordinal() != 1 ? this.defaultVoiceStateBackground : 2131231373);
        float f = (displayVoiceState == VoiceUserView$a.DISCONNECTED && this.fadeWhenDisconnected) ? 0.3f : 1.0f;
        SimpleDraweeView simpleDraweeView = this.binding.f141b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        simpleDraweeView.setAlpha(f);
        setAlpha(f);
        this.ringAnimator.onUpdate();
    }
}
