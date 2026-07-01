package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup$LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import b.a.i.v1;
import com.discord.R$a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages$DistinctChangeDetector;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.z.d.m;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final v1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MGImages$DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int cutoutSpacePx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R$layout.user_avatar_presence_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R$id.avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R$id.avatar);
        if (simpleDraweeView != null) {
            i = R$id.avatar_container;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R$id.avatar_container);
            if (frameLayout != null) {
                i = R$id.avatar_cutout;
                ImageView imageView = (ImageView) viewInflate.findViewById(R$id.avatar_cutout);
                if (imageView != null) {
                    i = R$id.static_avatar;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(R$id.static_avatar);
                    if (simpleDraweeView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        i = R$id.user_avatar_presence_status;
                        StatusView statusView = (StatusView) viewInflate.findViewById(R$id.user_avatar_presence_status);
                        if (statusView != null) {
                            v1 v1Var = new v1(relativeLayout, simpleDraweeView, frameLayout, imageView, simpleDraweeView2, relativeLayout, statusView);
                            m.checkNotNullExpressionValue(v1Var, "UserAvatarPresenceViewBi…rom(context), this, true)");
                            this.binding = v1Var;
                            this.imagesChangeDetector = new MGImages$DistinctChangeDetector();
                            this.onAvatarBitmapLoadedListener = UserAvatarPresenceView$b.j;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$a.UserAvatarPresenceView);
                            m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.UserAvatarPresenceView)");
                            int color = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, 2130969997));
                            this.cutoutSpacePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
                            typedArrayObtainStyledAttributes.recycle();
                            setAvatarBackgroundColor(color);
                            m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
                            simpleDraweeView.setClipToOutline(true);
                            return;
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    /* JADX WARN: Code duplicated, block: B:43:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:47:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:54:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    public final void a(UserAvatarPresenceView$a viewState) {
        boolean zIsDataUrlForGif;
        String forUser$default;
        String forGuildMember$default;
        String forUser$default2;
        boolean z2;
        m.checkNotNullParameter(viewState, "viewState");
        GuildMember guildMember = viewState.e;
        User user = viewState.a;
        boolean z3 = !AccessibilityUtils.INSTANCE.isReducedMotionEnabled();
        if (guildMember != null && guildMember.hasAvatar()) {
            forUser$default = guildMember.getAvatarHash();
            if (forUser$default == null || !t.startsWith$default(forUser$default, "data:", false, 2, null)) {
                if (forUser$default != null) {
                    z2 = z3 && IconUtils.INSTANCE.isImageHashAnimated(forUser$default);
                } else {
                    z2 = false;
                }
                forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, z3, 2, null);
                zIsDataUrlForGif = z2;
            } else {
                zIsDataUrlForGif = IconUtils.INSTANCE.isDataUrlForGif(forUser$default);
            }
            SimpleDraweeView simpleDraweeView = this.binding.f215b;
            m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, 0, new UserAvatarPresenceView$c(this, forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
            if (zIsDataUrlForGif) {
                if (guildMember == null && guildMember.hasAvatar()) {
                    forUser$default2 = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, false, 2, null);
                } else {
                    forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
                }
                String str = forUser$default2;
                SimpleDraweeView simpleDraweeView2 = this.binding.d;
                m.checkNotNullExpressionValue(simpleDraweeView2, "binding.staticAvatar");
                IconUtils.setIcon$default(simpleDraweeView2, str, 0, new UserAvatarPresenceView$d(this, str), this.imagesChangeDetector, 4, (Object) null);
            }
            StatusView statusView = this.binding.e;
            m.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
            statusView.setVisibility(!viewState.d && UserUtils.INSTANCE.isStatusVisible(viewState.a, viewState.f2846b, true) ? 0 : 8);
            this.binding.e.setPresence(viewState.f2846b);
        }
        String avatar = user.getAvatar();
        if (avatar == null || !t.startsWith$default(avatar, "data:", false, 2, null)) {
            String avatar2 = user.getAvatar();
            if (avatar2 != null) {
                zIsDataUrlForGif = z3 && IconUtils.INSTANCE.isImageHashAnimated(avatar2);
            } else {
                zIsDataUrlForGif = false;
            }
            forUser$default = IconUtils.getForUser$default(viewState.a, z3, null, 4, null);
        } else {
            forUser$default = user.getAvatar();
            zIsDataUrlForGif = forUser$default != null && IconUtils.INSTANCE.isDataUrlForGif(forUser$default);
        }
        forGuildMember$default = forUser$default;
        SimpleDraweeView simpleDraweeView3 = this.binding.f215b;
        m.checkNotNullExpressionValue(simpleDraweeView3, "binding.avatar");
        IconUtils.setIcon$default(simpleDraweeView3, forGuildMember$default, 0, new UserAvatarPresenceView$c(this, forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
        if (zIsDataUrlForGif) {
            if (guildMember == null) {
                forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
            } else {
                forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
            }
            String str2 = forUser$default2;
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.staticAvatar");
            IconUtils.setIcon$default(simpleDraweeView4, str2, 0, new UserAvatarPresenceView$d(this, str2), this.imagesChangeDetector, 4, (Object) null);
        }
        StatusView statusView2 = this.binding.e;
        m.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setVisibility(!viewState.d && UserUtils.INSTANCE.isStatusVisible(viewState.a, viewState.f2846b, true) ? 0 : 8);
        this.binding.e.setPresence(viewState.f2846b);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View$MeasureSpec.getSize(widthMeasureSpec);
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ViewGroup$LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.setLayoutParams(layoutParams);
        int i = size - (this.cutoutSpacePx * 2);
        SimpleDraweeView simpleDraweeView = this.binding.f215b;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
        ViewGroup$LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.width = i;
        layoutParams2.height = i;
        simpleDraweeView.setLayoutParams(layoutParams2);
        float f = size;
        float f2 = 0.3375f * f;
        float f3 = 0.0375f * f;
        float f4 = f * 0.05f;
        Resources resources = getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        float f5 = resources.getDisplayMetrics().density;
        float f6 = 12 * f5;
        if (f2 < f6) {
            float f7 = f6 / f2;
            f2 *= f7;
            f3 *= f7;
            f4 *= f7;
        }
        float f8 = f3;
        float fMax = Math.max(f3, f5 * 2);
        StatusView statusView = this.binding.e;
        m.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
        ViewGroup$LayoutParams layoutParams3 = statusView.getLayoutParams();
        layoutParams3.width = (int) f2;
        StatusView statusView2 = this.binding.e;
        m.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setLayoutParams(layoutParams3);
        StatusView statusView3 = this.binding.e;
        m.checkNotNullExpressionValue(statusView3, "binding.userAvatarPresenceStatus");
        statusView3.setTranslationX(f8 - this.cutoutSpacePx);
        StatusView statusView4 = this.binding.e;
        m.checkNotNullExpressionValue(statusView4, "binding.userAvatarPresenceStatus");
        statusView4.setTranslationY(f8 - this.cutoutSpacePx);
        this.binding.e.setBorderWidth((int) fMax);
        this.binding.e.setCornerRadius(f4);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        this.binding.e.setBackgroundColor(backgroundColor);
        ImageView imageView = this.binding.c;
        m.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ColorCompatKt.tintWithColor(imageView, backgroundColor);
    }

    public final void setOnAvatarBitmapLoadedListener(Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener) {
        m.checkNotNullParameter(onAvatarBitmapLoadedListener, "onAvatarBitmapLoadedListener");
        this.onAvatarBitmapLoadedListener = onAvatarBitmapLoadedListener;
    }
}
