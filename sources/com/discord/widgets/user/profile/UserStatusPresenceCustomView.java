package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ViewUserStatusPresenceCustomBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.stores.StoreStream;
import com.discord.utilities.fresco.GrayscalePostprocessor;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserStatusPresenceCustomView extends LinearLayout {
    private final ViewUserStatusPresenceCustomBinding binding;
    private static final GrayscalePostprocessor CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR = new GrayscalePostprocessor();

    /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
    public static final /* data */ class Emoji {
        private final String id;
        private final boolean isAnimated;
        private final String name;

        public Emoji(String str, String str2, boolean z2) {
            this.id = str;
            this.name = str2;
            this.isAnimated = z2;
        }

        public static /* synthetic */ Emoji copy$default(Emoji emoji, String str, String str2, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = emoji.id;
            }
            if ((i & 2) != 0) {
                str2 = emoji.name;
            }
            if ((i & 4) != 0) {
                z2 = emoji.isAnimated;
            }
            return emoji.copy(str, str2, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getId() {
            return this.id;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getName() {
            return this.name;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsAnimated() {
            return this.isAnimated;
        }

        public final Emoji copy(String id2, String name, boolean isAnimated) {
            return new Emoji(id2, name, isAnimated);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Emoji)) {
                return false;
            }
            Emoji emoji = (Emoji) other;
            return Intrinsics3.areEqual(this.id, emoji.id) && Intrinsics3.areEqual(this.name, emoji.name) && this.isAnimated == emoji.isAnimated;
        }

        public final String getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public int hashCode() {
            String str = this.id;
            int iHashCode = (str != null ? str.hashCode() : 0) * 31;
            String str2 = this.name;
            int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
            boolean z2 = this.isAnimated;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode2 + r1;
        }

        public final boolean isAnimated() {
            return this.isAnimated;
        }

        public String toString() {
            StringBuilder sbU = outline.U("Emoji(id=");
            sbU.append(this.id);
            sbU.append(", name=");
            sbU.append(this.name);
            sbU.append(", isAnimated=");
            return outline.O(sbU, this.isAnimated, ")");
        }
    }

    /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
        public static final /* data */ class WithPlaceholder extends ViewState {
            private final ModelEmojiUnicode placeholderEmoji;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public WithPlaceholder(ModelEmojiUnicode modelEmojiUnicode) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "placeholderEmoji");
                this.placeholderEmoji = modelEmojiUnicode;
            }

            public static /* synthetic */ WithPlaceholder copy$default(WithPlaceholder withPlaceholder, ModelEmojiUnicode modelEmojiUnicode, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiUnicode = withPlaceholder.placeholderEmoji;
                }
                return withPlaceholder.copy(modelEmojiUnicode);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelEmojiUnicode getPlaceholderEmoji() {
                return this.placeholderEmoji;
            }

            public final WithPlaceholder copy(ModelEmojiUnicode placeholderEmoji) {
                Intrinsics3.checkNotNullParameter(placeholderEmoji, "placeholderEmoji");
                return new WithPlaceholder(placeholderEmoji);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof WithPlaceholder) && Intrinsics3.areEqual(this.placeholderEmoji, ((WithPlaceholder) other).placeholderEmoji);
                }
                return true;
            }

            public final ModelEmojiUnicode getPlaceholderEmoji() {
                return this.placeholderEmoji;
            }

            public int hashCode() {
                ModelEmojiUnicode modelEmojiUnicode = this.placeholderEmoji;
                if (modelEmojiUnicode != null) {
                    return modelEmojiUnicode.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("WithPlaceholder(placeholderEmoji=");
                sbU.append(this.placeholderEmoji);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
        public static final /* data */ class WithStatus extends ViewState {
            private final Emoji emoji;
            private final String statusText;

            public WithStatus(Emoji emoji, String str) {
                super(null);
                this.emoji = emoji;
                this.statusText = str;
            }

            public static /* synthetic */ WithStatus copy$default(WithStatus withStatus, Emoji emoji, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    emoji = withStatus.emoji;
                }
                if ((i & 2) != 0) {
                    str = withStatus.statusText;
                }
                return withStatus.copy(emoji, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Emoji getEmoji() {
                return this.emoji;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getStatusText() {
                return this.statusText;
            }

            public final WithStatus copy(Emoji emoji, String statusText) {
                return new WithStatus(emoji, statusText);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof WithStatus)) {
                    return false;
                }
                WithStatus withStatus = (WithStatus) other;
                return Intrinsics3.areEqual(this.emoji, withStatus.emoji) && Intrinsics3.areEqual(this.statusText, withStatus.statusText);
            }

            public final Emoji getEmoji() {
                return this.emoji;
            }

            public final String getStatusText() {
                return this.statusText;
            }

            public int hashCode() {
                Emoji emoji = this.emoji;
                int iHashCode = (emoji != null ? emoji.hashCode() : 0) * 31;
                String str = this.statusText;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("WithStatus(emoji=");
                sbU.append(this.emoji);
                sbU.append(", statusText=");
                return outline.J(sbU, this.statusText, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.profile.UserStatusPresenceCustomView$configurePlaceholderEmoji$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ImageRequestBuilder, Unit> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            Intrinsics3.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.l = UserStatusPresenceCustomView.CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStatusPresenceCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(R.layout.view_user_status_presence_custom, (ViewGroup) this, false);
        addView(viewInflate);
        int i = R.id.user_status_presence_custom_clear;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(R.id.user_status_presence_custom_clear);
        if (appCompatImageView != null) {
            i = R.id.user_status_presence_custom_emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.user_status_presence_custom_emoji);
            if (simpleDraweeView != null) {
                i = R.id.user_status_presence_custom_text;
                TextView textView = (TextView) viewInflate.findViewById(R.id.user_status_presence_custom_text);
                if (textView != null) {
                    ViewUserStatusPresenceCustomBinding viewUserStatusPresenceCustomBinding = new ViewUserStatusPresenceCustomBinding((LinearLayout) viewInflate, appCompatImageView, simpleDraweeView, textView);
                    Intrinsics3.checkNotNullExpressionValue(viewUserStatusPresenceCustomBinding, "ViewUserStatusPresenceCu…rom(context), this, true)");
                    this.binding = viewUserStatusPresenceCustomBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configurePlaceholderEmoji(ModelEmojiUnicode placeholderEmoji) {
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiUnicode.getImageUri(placeholderEmoji.getCodePoints(), getContext()), 0, 0, false, AnonymousClass1.INSTANCE, null, 92, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(0);
    }

    private final void configureStatusEmoji(Emoji emoji) {
        String imageUri = null;
        if (emoji != null) {
            if (emoji.getId() != null) {
                imageUri = ModelEmojiCustom.getImageUri(Long.parseLong(emoji.getId()), emoji.isAnimated(), IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(R.dimen.custom_status_emoji_preview_size)));
            } else {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(emoji.getName());
                if (modelEmojiUnicode != null) {
                    imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode.getCodePoints(), getContext());
                }
            }
        }
        SimpleDraweeView simpleDraweeView = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.c;
        Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(imageUri != null ? 0 : 8);
    }

    public final void setOnClear(final Function0<Unit> onClear) {
        Intrinsics3.checkNotNullParameter(onClear, "onClear");
        this.binding.f2216b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserStatusPresenceCustomView.setOnClear.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClear.invoke();
            }
        });
    }

    public final void updateViewState(ViewState viewState) {
        Intrinsics3.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof ViewState.WithStatus)) {
            if (viewState instanceof ViewState.WithPlaceholder) {
                configurePlaceholderEmoji(((ViewState.WithPlaceholder) viewState).getPlaceholderEmoji());
                this.binding.d.setText(R.string.custom_status_set_custom_status);
                AppCompatImageView appCompatImageView = this.binding.f2216b;
                Intrinsics3.checkNotNullExpressionValue(appCompatImageView, "binding.userStatusPresenceCustomClear");
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        ViewState.WithStatus withStatus = (ViewState.WithStatus) viewState;
        configureStatusEmoji(withStatus.getEmoji());
        TextView textView = this.binding.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.userStatusPresenceCustomText");
        textView.setText(withStatus.getStatusText());
        AppCompatImageView appCompatImageView2 = this.binding.f2216b;
        Intrinsics3.checkNotNullExpressionValue(appCompatImageView2, "binding.userStatusPresenceCustomClear");
        appCompatImageView2.setVisibility(0);
    }
}
