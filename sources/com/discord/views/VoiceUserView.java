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
import com.discord.C5419R;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.anim.RingAnimator;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.C0986j4;
import p007b.p008a.p062y.C1332g0;
import p007b.p008a.p062y.C1334h0;
import p007b.p008a.p062y.C1336i0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: VoiceUserView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class VoiceUserView extends FrameLayout {

    /* JADX INFO: renamed from: j */
    public static final /* synthetic */ int f19182j = 0;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int defaultVoiceStateBackground;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final C0986j4 binding;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public EnumC7097a displayVoiceState;

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

    /* JADX INFO: renamed from: s, reason: from kotlin metadata */
    public boolean animateAvatarWhenRinging;

    /* JADX INFO: renamed from: com.discord.views.VoiceUserView$a */
    /* JADX INFO: compiled from: VoiceUserView.kt */
    public enum EnumC7097a {
        CONNECTED,
        SPEAKING,
        MUTED,
        RINGING,
        DISCONNECTED
    }

    /* JADX INFO: renamed from: com.discord.views.VoiceUserView$b */
    /* JADX INFO: compiled from: VoiceUserView.kt */
    public static final class C7098b extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ int $avatarSize;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7098b(int i) {
            super(1);
            this.$avatarSize = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "$this$resizeLayoutParams");
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

    /* JADX INFO: renamed from: com.discord.views.VoiceUserView$c */
    /* JADX INFO: compiled from: VoiceUserView.kt */
    public static final class C7099c extends AbstractC12240o implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $newAvatarUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7099c(String str) {
            super(1);
            this.$newAvatarUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            C12238m.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.f19623l = new C1336i0(this);
            return Unit.f27425a;
        }
    }

    public VoiceUserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public VoiceUserView(Context context, AttributeSet attributeSet, int i, int i2) {
        attributeSet = (i2 & 2) != 0 ? null : attributeSet;
        i = (i2 & 4) != 0 ? 0 : i;
        C12238m.checkNotNullParameter(context, "context");
        super(context, attributeSet, i);
        this.defaultVoiceStateBackground = R.color.transparent;
        LayoutInflater.from(context).inflate(C5419R.layout.view_voice_user, this);
        int i3 = C5419R.id.voice_user_avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.voice_user_avatar);
        if (simpleDraweeView != null) {
            i3 = C5419R.id.voice_user_name_display;
            TextView textView = (TextView) findViewById(C5419R.id.voice_user_name_display);
            if (textView != null) {
                C0986j4 c0986j4 = new C0986j4(this, simpleDraweeView, textView);
                C12238m.checkNotNullExpressionValue(c0986j4, "ViewVoiceUserBinding.inf…ater.from(context), this)");
                this.binding = c0986j4;
                this.ringAnimator = new RingAnimator(this, new C1334h0(this));
                this.onBitmapLoadedListener = C1332g0.f2025j;
                if (attributeSet != null) {
                    TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.VoiceUserView, 0, 0);
                    C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…able.VoiceUserView, 0, 0)");
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
        EnumC7097a enumC7097a;
        VoiceState voiceState = voiceUser.getVoiceState();
        boolean z2 = voiceState != null && (voiceState.getSelfMute() || voiceState.getMute() || voiceState.getSuppress());
        if (voiceUser.getIsSpeaking()) {
            enumC7097a = EnumC7097a.SPEAKING;
        } else if (voiceUser.isRinging()) {
            enumC7097a = EnumC7097a.RINGING;
        } else if (voiceUser.isConnected()) {
            enumC7097a = z2 ? EnumC7097a.MUTED : EnumC7097a.CONNECTED;
        } else {
            enumC7097a = EnumC7097a.DISCONNECTED;
        }
        setVoiceState(enumC7097a);
    }

    @MainThread
    /* JADX INFO: renamed from: a */
    public final void m8570a(StoreVoiceParticipants.VoiceUser voiceUser, @DimenRes int sizeDimenRes) {
        C12238m.checkNotNullParameter(voiceUser, "voiceUser");
        if (C12238m.areEqual(this.voiceUser, voiceUser)) {
            return;
        }
        this.voiceUser = voiceUser;
        int dimensionPixelSize = getResources().getDimensionPixelSize(sizeDimenRes);
        Integer numValueOf = dimensionPixelSize > 0 ? Integer.valueOf(IconUtils.getMediaProxySize(dimensionPixelSize)) : null;
        GuildMember guildMember = voiceUser.getGuildMember();
        IconUtils iconUtils = IconUtils.INSTANCE;
        StoreVoiceParticipants.VoiceUser voiceUser2 = this.voiceUser;
        String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(iconUtils, voiceUser2 != null ? voiceUser2.getUser() : null, guildMember, numValueOf, false, 8, null);
        if (!C12238m.areEqual(this.prevAvatarUrl, forGuildMemberOrUser$default)) {
            this.prevAvatarUrl = forGuildMemberOrUser$default;
            SimpleDraweeView simpleDraweeView = this.binding.f980b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMemberOrUser$default, sizeDimenRes, new C7099c(forGuildMemberOrUser$default), (MGImages.ChangeDetector) null, 16, (Object) null);
        }
        TextView textView = this.binding.f981c;
        C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        textView.setText(voiceUser.getDisplayName());
        setVoiceState(voiceUser);
    }

    @MainThread
    public final void setAnimateAvatarWhenRinging(boolean animateAvatarWhenRinging) {
        this.animateAvatarWhenRinging = animateAvatarWhenRinging;
    }

    @MainThread
    public final void setAvatarSize(int avatarSize) {
        C7098b c7098b = new C7098b(avatarSize);
        SimpleDraweeView simpleDraweeView = this.binding.f980b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        c7098b.invoke2((View) simpleDraweeView);
        TextView textView = this.binding.f981c;
        C12238m.checkNotNullExpressionValue(textView, "binding.voiceUserNameDisplay");
        c7098b.invoke2((View) textView);
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
        C12238m.checkNotNullParameter(onBitmapLoadedListener, "onBitmapLoadedListener");
        this.onBitmapLoadedListener = onBitmapLoadedListener;
    }

    @MainThread
    public final void setRingMargin(@Px int size) {
        SimpleDraweeView simpleDraweeView = this.binding.f980b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        SimpleDraweeView simpleDraweeView2 = this.binding.f980b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.voiceUserAvatar");
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
            ViewExtensions.fadeBy$default(this.binding.f981c, isSelected(), 0L, 2, null);
        }
    }

    @MainThread
    public final void setVoiceUser(StoreVoiceParticipants.VoiceUser voiceUser) {
        m8570a(voiceUser, C5419R.dimen.avatar_size_unrestricted);
    }

    private final void setVoiceState(EnumC7097a displayVoiceState) {
        if (displayVoiceState == this.displayVoiceState) {
            return;
        }
        this.displayVoiceState = displayVoiceState;
        setBackgroundResource(displayVoiceState.ordinal() != 1 ? this.defaultVoiceStateBackground : C5419R.drawable.drawable_voice_user_background_speaking);
        float f = (displayVoiceState == EnumC7097a.DISCONNECTED && this.fadeWhenDisconnected) ? 0.3f : 1.0f;
        SimpleDraweeView simpleDraweeView = this.binding.f980b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.voiceUserAvatar");
        simpleDraweeView.setAlpha(f);
        setAlpha(f);
        this.ringAnimator.onUpdate();
    }
}
