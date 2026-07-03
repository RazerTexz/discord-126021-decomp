package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorInt;
import com.discord.C5419R;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import p007b.p008a.p025i.C1067v1;
import p007b.p008a.p062y.p072s0.C1382a;
import p007b.p008a.p062y.p072s0.C1383b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1067v1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int cutoutSpacePx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener;

    /* JADX INFO: renamed from: com.discord.views.user.UserAvatarPresenceView$b */
    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class C7132b extends AbstractC12240o implements Function2<Bitmap, String, Unit> {

        /* JADX INFO: renamed from: j */
        public static final C7132b f19360j = new C7132b();

        public C7132b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Bitmap bitmap, String str) {
            C12238m.checkNotNullParameter(bitmap, "<anonymous parameter 0>");
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.user.UserAvatarPresenceView$c */
    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class C7133c extends AbstractC12240o implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7133c(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            C12238m.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.f19623l = new C1382a(this);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.views.user.UserAvatarPresenceView$d */
    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class C7134d extends AbstractC12240o implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C7134d(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            C12238m.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.f19623l = new C1383b(this);
            return Unit.f27425a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.user_avatar_presence_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.avatar);
        if (simpleDraweeView != null) {
            i = C5419R.id.avatar_container;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(C5419R.id.avatar_container);
            if (frameLayout != null) {
                i = C5419R.id.avatar_cutout;
                ImageView imageView = (ImageView) viewInflate.findViewById(C5419R.id.avatar_cutout);
                if (imageView != null) {
                    i = C5419R.id.static_avatar;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.static_avatar);
                    if (simpleDraweeView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        i = C5419R.id.user_avatar_presence_status;
                        StatusView statusView = (StatusView) viewInflate.findViewById(C5419R.id.user_avatar_presence_status);
                        if (statusView != null) {
                            C1067v1 c1067v1 = new C1067v1(relativeLayout, simpleDraweeView, frameLayout, imageView, simpleDraweeView2, relativeLayout, statusView);
                            C12238m.checkNotNullExpressionValue(c1067v1, "UserAvatarPresenceViewBi…rom(context), this, true)");
                            this.binding = c1067v1;
                            this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
                            this.onAvatarBitmapLoadedListener = C7132b.f19360j;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C5419R.a.UserAvatarPresenceView);
                            C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.UserAvatarPresenceView)");
                            int color = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, C5419R.attr.primary_700));
                            this.cutoutSpacePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
                            typedArrayObtainStyledAttributes.recycle();
                            setAvatarBackgroundColor(color);
                            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
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
    /* JADX INFO: renamed from: a */
    public final void m8622a(C7131a viewState) {
        boolean zIsDataUrlForGif;
        String forUser$default;
        String forGuildMember$default;
        String forUser$default2;
        boolean z2;
        C12238m.checkNotNullParameter(viewState, "viewState");
        GuildMember guildMember = viewState.f19359e;
        User user = viewState.f19355a;
        boolean z3 = !AccessibilityUtils.INSTANCE.isReducedMotionEnabled();
        if (guildMember != null && guildMember.hasAvatar()) {
            forUser$default = guildMember.getAvatarHash();
            if (forUser$default == null || !C12103t.startsWith$default(forUser$default, "data:", false, 2, null)) {
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
            SimpleDraweeView simpleDraweeView = this.binding.f1310b;
            C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, 0, new C7133c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
            if (zIsDataUrlForGif) {
                if (guildMember == null && guildMember.hasAvatar()) {
                    forUser$default2 = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, false, 2, null);
                } else {
                    forUser$default2 = IconUtils.getForUser$default(viewState.f19355a, false, null, 4, null);
                }
                String str = forUser$default2;
                SimpleDraweeView simpleDraweeView2 = this.binding.f1312d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.staticAvatar");
                IconUtils.setIcon$default(simpleDraweeView2, str, 0, new C7134d(str), this.imagesChangeDetector, 4, (Object) null);
            }
            StatusView statusView = this.binding.f1313e;
            C12238m.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
            statusView.setVisibility(!viewState.f19358d && UserUtils.INSTANCE.isStatusVisible(viewState.f19355a, viewState.f19356b, true) ? 0 : 8);
            this.binding.f1313e.setPresence(viewState.f19356b);
        }
        String avatar = user.getAvatar();
        if (avatar == null || !C12103t.startsWith$default(avatar, "data:", false, 2, null)) {
            String avatar2 = user.getAvatar();
            if (avatar2 != null) {
                zIsDataUrlForGif = z3 && IconUtils.INSTANCE.isImageHashAnimated(avatar2);
            } else {
                zIsDataUrlForGif = false;
            }
            forUser$default = IconUtils.getForUser$default(viewState.f19355a, z3, null, 4, null);
        } else {
            forUser$default = user.getAvatar();
            zIsDataUrlForGif = forUser$default != null && IconUtils.INSTANCE.isDataUrlForGif(forUser$default);
        }
        forGuildMember$default = forUser$default;
        SimpleDraweeView simpleDraweeView3 = this.binding.f1310b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.avatar");
        IconUtils.setIcon$default(simpleDraweeView3, forGuildMember$default, 0, new C7133c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
        if (zIsDataUrlForGif) {
            if (guildMember == null) {
                forUser$default2 = IconUtils.getForUser$default(viewState.f19355a, false, null, 4, null);
            } else {
                forUser$default2 = IconUtils.getForUser$default(viewState.f19355a, false, null, 4, null);
            }
            String str2 = forUser$default2;
            SimpleDraweeView simpleDraweeView4 = this.binding.f1312d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.staticAvatar");
            IconUtils.setIcon$default(simpleDraweeView4, str2, 0, new C7134d(str2), this.imagesChangeDetector, 4, (Object) null);
        }
        StatusView statusView2 = this.binding.f1313e;
        C12238m.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setVisibility(!viewState.f19358d && UserUtils.INSTANCE.isStatusVisible(viewState.f19355a, viewState.f19356b, true) ? 0 : 8);
        this.binding.f1313e.setPresence(viewState.f19356b);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        ImageView imageView = this.binding.f1311c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.setLayoutParams(layoutParams);
        int i = size - (this.cutoutSpacePx * 2);
        SimpleDraweeView simpleDraweeView = this.binding.f1310b;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
        ViewGroup.LayoutParams layoutParams2 = simpleDraweeView.getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams2.width = i;
        layoutParams2.height = i;
        simpleDraweeView.setLayoutParams(layoutParams2);
        float f = size;
        float f2 = 0.3375f * f;
        float f3 = 0.0375f * f;
        float f4 = f * 0.05f;
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
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
        StatusView statusView = this.binding.f1313e;
        C12238m.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
        ViewGroup.LayoutParams layoutParams3 = statusView.getLayoutParams();
        layoutParams3.width = (int) f2;
        StatusView statusView2 = this.binding.f1313e;
        C12238m.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setLayoutParams(layoutParams3);
        StatusView statusView3 = this.binding.f1313e;
        C12238m.checkNotNullExpressionValue(statusView3, "binding.userAvatarPresenceStatus");
        statusView3.setTranslationX(f8 - this.cutoutSpacePx);
        StatusView statusView4 = this.binding.f1313e;
        C12238m.checkNotNullExpressionValue(statusView4, "binding.userAvatarPresenceStatus");
        statusView4.setTranslationY(f8 - this.cutoutSpacePx);
        this.binding.f1313e.setBorderWidth((int) fMax);
        this.binding.f1313e.setCornerRadius(f4);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        this.binding.f1313e.setBackgroundColor(backgroundColor);
        ImageView imageView = this.binding.f1311c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ColorCompatKt.tintWithColor(imageView, backgroundColor);
    }

    public final void setOnAvatarBitmapLoadedListener(Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener) {
        C12238m.checkNotNullParameter(onAvatarBitmapLoadedListener, "onAvatarBitmapLoadedListener");
        this.onAvatarBitmapLoadedListener = onAvatarBitmapLoadedListener;
    }

    /* JADX INFO: renamed from: com.discord.views.user.UserAvatarPresenceView$a */
    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class C7131a {

        /* JADX INFO: renamed from: a */
        public final User f19355a;

        /* JADX INFO: renamed from: b */
        public final Presence f19356b;

        /* JADX INFO: renamed from: c */
        public final StreamContext f19357c;

        /* JADX INFO: renamed from: d */
        public final boolean f19358d;

        /* JADX INFO: renamed from: e */
        public final GuildMember f19359e;

        public C7131a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember, int i) {
            int i2 = i & 16;
            C12238m.checkNotNullParameter(user, "user");
            this.f19355a = user;
            this.f19356b = presence;
            this.f19357c = streamContext;
            this.f19358d = z2;
            this.f19359e = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C7131a)) {
                return false;
            }
            C7131a c7131a = (C7131a) obj;
            return C12238m.areEqual(this.f19355a, c7131a.f19355a) && C12238m.areEqual(this.f19356b, c7131a.f19356b) && C12238m.areEqual(this.f19357c, c7131a.f19357c) && this.f19358d == c7131a.f19358d && C12238m.areEqual(this.f19359e, c7131a.f19359e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            User user = this.f19355a;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Presence presence = this.f19356b;
            int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.f19357c;
            int iHashCode3 = (iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            boolean z2 = this.f19358d;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            GuildMember guildMember = this.f19359e;
            return i + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("ViewState(user=");
            sbM833U.append(this.f19355a);
            sbM833U.append(", presence=");
            sbM833U.append(this.f19356b);
            sbM833U.append(", streamContext=");
            sbM833U.append(this.f19357c);
            sbM833U.append(", showPresence=");
            sbM833U.append(this.f19358d);
            sbM833U.append(", guildMember=");
            sbM833U.append(this.f19359e);
            sbM833U.append(")");
            return sbM833U.toString();
        }

        public C7131a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember) {
            C12238m.checkNotNullParameter(user, "user");
            this.f19355a = user;
            this.f19356b = presence;
            this.f19357c = streamContext;
            this.f19358d = z2;
            this.f19359e = guildMember;
        }
    }
}
