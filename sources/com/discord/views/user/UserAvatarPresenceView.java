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
import b.a.i.UserAvatarPresenceViewBinding;
import b.a.y.s0.UserAvatarPresenceView2;
import b.a.y.s0.UserAvatarPresenceView3;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.user.UserUtils;
import com.discord.views.StatusView;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: UserAvatarPresenceView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAvatarPresenceView extends RelativeLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final UserAvatarPresenceViewBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final MGImages.DistinctChangeDetector imagesChangeDetector;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int cutoutSpacePx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener;

    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class b extends Lambda implements Function2<Bitmap, String, Unit> {
        public static final b j = new b();

        public b() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public Unit invoke(Bitmap bitmap, String str) {
            Intrinsics3.checkNotNullParameter(bitmap, "<anonymous parameter 0>");
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class c extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            Intrinsics3.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.l = new UserAvatarPresenceView2(this);
            return Unit.a;
        }
    }

    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class d extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public final /* synthetic */ String $iconUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(String str) {
            super(1);
            this.$iconUrl = str;
        }

        @Override // kotlin.jvm.functions.Function1
        public Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            ImageRequestBuilder imageRequestBuilder2 = imageRequestBuilder;
            Intrinsics3.checkNotNullParameter(imageRequestBuilder2, "imageRequestBuilder");
            imageRequestBuilder2.l = new UserAvatarPresenceView3(this);
            return Unit.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAvatarPresenceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.user_avatar_presence_view, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.avatar;
        SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.avatar);
        if (simpleDraweeView != null) {
            i = R.id.avatar_container;
            FrameLayout frameLayout = (FrameLayout) viewInflate.findViewById(R.id.avatar_container);
            if (frameLayout != null) {
                i = R.id.avatar_cutout;
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.avatar_cutout);
                if (imageView != null) {
                    i = R.id.static_avatar;
                    SimpleDraweeView simpleDraweeView2 = (SimpleDraweeView) viewInflate.findViewById(R.id.static_avatar);
                    if (simpleDraweeView2 != null) {
                        RelativeLayout relativeLayout = (RelativeLayout) viewInflate;
                        i = R.id.user_avatar_presence_status;
                        StatusView statusView = (StatusView) viewInflate.findViewById(R.id.user_avatar_presence_status);
                        if (statusView != null) {
                            UserAvatarPresenceViewBinding userAvatarPresenceViewBinding = new UserAvatarPresenceViewBinding(relativeLayout, simpleDraweeView, frameLayout, imageView, simpleDraweeView2, relativeLayout, statusView);
                            Intrinsics3.checkNotNullExpressionValue(userAvatarPresenceViewBinding, "UserAvatarPresenceViewBi…rom(context), this, true)");
                            this.binding = userAvatarPresenceViewBinding;
                            this.imagesChangeDetector = new MGImages.DistinctChangeDetector();
                            this.onAvatarBitmapLoadedListener = b.j;
                            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.a.UserAvatarPresenceView);
                            Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "context.obtainStyledAttr…e.UserAvatarPresenceView)");
                            int color = typedArrayObtainStyledAttributes.getColor(0, ColorCompat.getThemedColor(this, R.attr.primary_700));
                            this.cutoutSpacePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 0);
                            typedArrayObtainStyledAttributes.recycle();
                            setAvatarBackgroundColor(color);
                            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
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
    public final void a(a viewState) {
        boolean zIsDataUrlForGif;
        String forUser$default;
        String forGuildMember$default;
        String forUser$default2;
        boolean z2;
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        GuildMember guildMember = viewState.e;
        User user = viewState.a;
        boolean z3 = !AccessibilityUtils.INSTANCE.isReducedMotionEnabled();
        if (guildMember != null && guildMember.hasAvatar()) {
            forUser$default = guildMember.getAvatarHash();
            if (forUser$default == null || !StringsJVM.startsWith$default(forUser$default, "data:", false, 2, null)) {
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
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
            IconUtils.setIcon$default(simpleDraweeView, forGuildMember$default, 0, new c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
            if (zIsDataUrlForGif) {
                if (guildMember == null && guildMember.hasAvatar()) {
                    forUser$default2 = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, guildMember, null, false, 2, null);
                } else {
                    forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
                }
                String str = forUser$default2;
                SimpleDraweeView simpleDraweeView2 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.staticAvatar");
                IconUtils.setIcon$default(simpleDraweeView2, str, 0, new d(str), this.imagesChangeDetector, 4, (Object) null);
            }
            StatusView statusView = this.binding.e;
            Intrinsics3.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
            statusView.setVisibility(!viewState.d && UserUtils.INSTANCE.isStatusVisible(viewState.a, viewState.f2846b, true) ? 0 : 8);
            this.binding.e.setPresence(viewState.f2846b);
        }
        String avatar = user.getAvatar();
        if (avatar == null || !StringsJVM.startsWith$default(avatar, "data:", false, 2, null)) {
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
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "binding.avatar");
        IconUtils.setIcon$default(simpleDraweeView3, forGuildMember$default, 0, new c(forGuildMember$default), this.imagesChangeDetector, 4, (Object) null);
        if (zIsDataUrlForGif) {
            if (guildMember == null) {
                forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
            } else {
                forUser$default2 = IconUtils.getForUser$default(viewState.a, false, null, 4, null);
            }
            String str2 = forUser$default2;
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            Intrinsics3.checkNotNullExpressionValue(simpleDraweeView4, "binding.staticAvatar");
            IconUtils.setIcon$default(simpleDraweeView4, str2, 0, new d(str2), this.imagesChangeDetector, 4, (Object) null);
        }
        StatusView statusView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setVisibility(!viewState.d && UserUtils.INSTANCE.isStatusVisible(viewState.a, viewState.f2846b, true) ? 0 : 8);
        this.binding.e.setPresence(viewState.f2846b);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(widthMeasureSpec);
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
        layoutParams.width = size;
        layoutParams.height = size;
        imageView.setLayoutParams(layoutParams);
        int i = size - (this.cutoutSpacePx * 2);
        SimpleDraweeView simpleDraweeView = this.binding.f215b;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.avatar");
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
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
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
        Intrinsics3.checkNotNullExpressionValue(statusView, "binding.userAvatarPresenceStatus");
        ViewGroup.LayoutParams layoutParams3 = statusView.getLayoutParams();
        layoutParams3.width = (int) f2;
        StatusView statusView2 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(statusView2, "binding.userAvatarPresenceStatus");
        statusView2.setLayoutParams(layoutParams3);
        StatusView statusView3 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(statusView3, "binding.userAvatarPresenceStatus");
        statusView3.setTranslationX(f8 - this.cutoutSpacePx);
        StatusView statusView4 = this.binding.e;
        Intrinsics3.checkNotNullExpressionValue(statusView4, "binding.userAvatarPresenceStatus");
        statusView4.setTranslationY(f8 - this.cutoutSpacePx);
        this.binding.e.setBorderWidth((int) fMax);
        this.binding.e.setCornerRadius(f4);
    }

    public final void setAvatarBackgroundColor(@ColorInt int backgroundColor) {
        this.binding.e.setBackgroundColor(backgroundColor);
        ImageView imageView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.avatarCutout");
        ColorCompat2.tintWithColor(imageView, backgroundColor);
    }

    public final void setOnAvatarBitmapLoadedListener(Function2<? super Bitmap, ? super String, Unit> onAvatarBitmapLoadedListener) {
        Intrinsics3.checkNotNullParameter(onAvatarBitmapLoadedListener, "onAvatarBitmapLoadedListener");
        this.onAvatarBitmapLoadedListener = onAvatarBitmapLoadedListener;
    }

    /* JADX INFO: compiled from: UserAvatarPresenceView.kt */
    public static final class a {
        public final User a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Presence f2846b;
        public final StreamContext c;
        public final boolean d;
        public final GuildMember e;

        public a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember, int i) {
            int i2 = i & 16;
            Intrinsics3.checkNotNullParameter(user, "user");
            this.a = user;
            this.f2846b = presence;
            this.c = streamContext;
            this.d = z2;
            this.e = null;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return Intrinsics3.areEqual(this.a, aVar.a) && Intrinsics3.areEqual(this.f2846b, aVar.f2846b) && Intrinsics3.areEqual(this.c, aVar.c) && this.d == aVar.d && Intrinsics3.areEqual(this.e, aVar.e);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            User user = this.a;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            Presence presence = this.f2846b;
            int iHashCode2 = (iHashCode + (presence != null ? presence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.c;
            int iHashCode3 = (iHashCode2 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            boolean z2 = this.d;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            GuildMember guildMember = this.e;
            return i + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(user=");
            sbU.append(this.a);
            sbU.append(", presence=");
            sbU.append(this.f2846b);
            sbU.append(", streamContext=");
            sbU.append(this.c);
            sbU.append(", showPresence=");
            sbU.append(this.d);
            sbU.append(", guildMember=");
            sbU.append(this.e);
            sbU.append(")");
            return sbU.toString();
        }

        public a(User user, Presence presence, StreamContext streamContext, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            this.a = user;
            this.f2846b = presence;
            this.c = streamContext;
            this.d = z2;
            this.e = guildMember;
        }
    }
}
