package com.discord.widgets.user.profile;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.C5419R;
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
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

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
            return C12238m.areEqual(this.id, emoji.id) && C12238m.areEqual(this.name, emoji.name) && this.isAnimated == emoji.isAnimated;
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
            StringBuilder sbM833U = C1643a.m833U("Emoji(id=");
            sbM833U.append(this.id);
            sbM833U.append(", name=");
            sbM833U.append(this.name);
            sbM833U.append(", isAnimated=");
            return C1643a.m827O(sbM833U, this.isAnimated, ")");
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
                C12238m.checkNotNullParameter(modelEmojiUnicode, "placeholderEmoji");
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
                C12238m.checkNotNullParameter(placeholderEmoji, "placeholderEmoji");
                return new WithPlaceholder(placeholderEmoji);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof WithPlaceholder) && C12238m.areEqual(this.placeholderEmoji, ((WithPlaceholder) other).placeholderEmoji);
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
                StringBuilder sbM833U = C1643a.m833U("WithPlaceholder(placeholderEmoji=");
                sbM833U.append(this.placeholderEmoji);
                sbM833U.append(")");
                return sbM833U.toString();
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
                return C12238m.areEqual(this.emoji, withStatus.emoji) && C12238m.areEqual(this.statusText, withStatus.statusText);
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
                StringBuilder sbM833U = C1643a.m833U("WithStatus(emoji=");
                sbM833U.append(this.emoji);
                sbM833U.append(", statusText=");
                return C1643a.m822J(sbM833U, this.statusText, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.user.profile.UserStatusPresenceCustomView$configurePlaceholderEmoji$1 */
    /* JADX INFO: compiled from: UserStatusPresenceCustomView.kt */
    public static final class C103121 extends AbstractC12240o implements Function1<ImageRequestBuilder, Unit> {
        public static final C103121 INSTANCE = new C103121();

        public C103121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ImageRequestBuilder imageRequestBuilder) {
            invoke2(imageRequestBuilder);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ImageRequestBuilder imageRequestBuilder) {
            C12238m.checkNotNullParameter(imageRequestBuilder, "it");
            imageRequestBuilder.f19623l = UserStatusPresenceCustomView.CUSTOM_EMOJI_PLACEHOLDER_POSTPROCESSOR;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserStatusPresenceCustomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(attributeSet, "attrs");
        View viewInflate = LayoutInflater.from(context).inflate(C5419R.layout.view_user_status_presence_custom, (ViewGroup) this, false);
        addView(viewInflate);
        int i = C5419R.id.user_status_presence_custom_clear;
        AppCompatImageView appCompatImageView = (AppCompatImageView) viewInflate.findViewById(C5419R.id.user_status_presence_custom_clear);
        if (appCompatImageView != null) {
            i = C5419R.id.user_status_presence_custom_emoji;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(C5419R.id.user_status_presence_custom_emoji);
            if (simpleDraweeView != null) {
                i = C5419R.id.user_status_presence_custom_text;
                TextView textView = (TextView) viewInflate.findViewById(C5419R.id.user_status_presence_custom_text);
                if (textView != null) {
                    ViewUserStatusPresenceCustomBinding viewUserStatusPresenceCustomBinding = new ViewUserStatusPresenceCustomBinding((LinearLayout) viewInflate, appCompatImageView, simpleDraweeView, textView);
                    C12238m.checkNotNullExpressionValue(viewUserStatusPresenceCustomBinding, "ViewUserStatusPresenceCu…rom(context), this, true)");
                    this.binding = viewUserStatusPresenceCustomBinding;
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void configurePlaceholderEmoji(ModelEmojiUnicode placeholderEmoji) {
        SimpleDraweeView simpleDraweeView = this.binding.f15589c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, ModelEmojiUnicode.getImageUri(placeholderEmoji.getCodePoints(), getContext()), 0, 0, false, C103121.INSTANCE, null, 92, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.f15589c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(0);
    }

    private final void configureStatusEmoji(Emoji emoji) {
        String imageUri = null;
        if (emoji != null) {
            if (emoji.getId() != null) {
                imageUri = ModelEmojiCustom.getImageUri(Long.parseLong(emoji.getId()), emoji.isAnimated(), IconUtils.getMediaProxySize(getResources().getDimensionPixelSize(C5419R.dimen.custom_status_emoji_preview_size)));
            } else {
                ModelEmojiUnicode modelEmojiUnicode = StoreStream.INSTANCE.getEmojis().getUnicodeEmojiSurrogateMap().get(emoji.getName());
                if (modelEmojiUnicode != null) {
                    imageUri = ModelEmojiUnicode.getImageUri(modelEmojiUnicode.getCodePoints(), getContext());
                }
            }
        }
        SimpleDraweeView simpleDraweeView = this.binding.f15589c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.userStatusPresenceCustomEmoji");
        MGImages.setImage$default(simpleDraweeView, imageUri, 0, 0, false, null, null, 124, null);
        SimpleDraweeView simpleDraweeView2 = this.binding.f15589c;
        C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.userStatusPresenceCustomEmoji");
        simpleDraweeView2.setVisibility(imageUri != null ? 0 : 8);
    }

    public final void setOnClear(final Function0<Unit> onClear) {
        C12238m.checkNotNullParameter(onClear, "onClear");
        this.binding.f15588b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.profile.UserStatusPresenceCustomView.setOnClear.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                onClear.invoke();
            }
        });
    }

    public final void updateViewState(ViewState viewState) {
        C12238m.checkNotNullParameter(viewState, "viewState");
        if (!(viewState instanceof ViewState.WithStatus)) {
            if (viewState instanceof ViewState.WithPlaceholder) {
                configurePlaceholderEmoji(((ViewState.WithPlaceholder) viewState).getPlaceholderEmoji());
                this.binding.f15590d.setText(C5419R.string.custom_status_set_custom_status);
                AppCompatImageView appCompatImageView = this.binding.f15588b;
                C12238m.checkNotNullExpressionValue(appCompatImageView, "binding.userStatusPresenceCustomClear");
                appCompatImageView.setVisibility(8);
                return;
            }
            return;
        }
        ViewState.WithStatus withStatus = (ViewState.WithStatus) viewState;
        configureStatusEmoji(withStatus.getEmoji());
        TextView textView = this.binding.f15590d;
        C12238m.checkNotNullExpressionValue(textView, "binding.userStatusPresenceCustomText");
        textView.setText(withStatus.getStatusText());
        AppCompatImageView appCompatImageView2 = this.binding.f15588b;
        C12238m.checkNotNullExpressionValue(appCompatImageView2, "binding.userStatusPresenceCustomClear");
        appCompatImageView2.setVisibility(0);
    }
}
