package com.discord.widgets.user.presence;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.MainThread;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.view.ViewKt;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import com.discord.api.activity.Activity;
import com.discord.api.activity.ActivityAssets;
import com.discord.api.activity.ActivityParty;
import com.discord.api.activity.ActivityTimestamps;
import com.discord.app.AppComponent;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.presence.PresenceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.g0.t;
import d0.g0.w;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ViewHolderUserRichPresence.kt */
/* JADX INFO: loaded from: classes.dex */
public class ViewHolderUserRichPresence {
    public static final int BASE_RICH_PRESENCE_TYPE = 0;
    public static final ViewHolderUserRichPresence$Companion Companion = new ViewHolderUserRichPresence$Companion(null);
    public static final int GAME_RICH_PRESENCE_TYPE = 1;
    public static final int MUSIC_RICH_PRESENCE_TYPE = 2;
    public static final int PLATFORM_RICH_PRESENCE_TYPE = 3;
    public static final int STAGE_CHANNEL_RICH_PRESENCE_TYPE = 5;
    public static final int STREAM_RICH_PRESENCE_TYPE = 4;
    private Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> onActivityCustomButtonClicked;
    private Subscription perSecondTimerSubscription;
    private final TextView richPresenceDetails;
    private final TextView richPresenceHeader;
    private final SimpleDraweeView richPresenceImageLarge;
    private final SimpleDraweeView richPresenceImageSmall;
    private final Button richPresencePrimaryButton;
    private final Button richPresenceSecondaryButton;
    private final TextView richPresenceState;
    private final View richPresenceTextContainer;
    private final TextView richPresenceTime;
    private final TextView richPresenceTitle;
    private final int richPresenceType;
    private final View root;

    public ViewHolderUserRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2, int i) {
        m.checkNotNullParameter(view, "root");
        m.checkNotNullParameter(simpleDraweeView, "richPresenceImageLarge");
        m.checkNotNullParameter(textView, "richPresenceHeader");
        m.checkNotNullParameter(textView2, "richPresenceTitle");
        m.checkNotNullParameter(textView4, "richPresenceTime");
        m.checkNotNullParameter(view2, "richPresenceTextContainer");
        this.root = view;
        this.richPresenceImageLarge = simpleDraweeView;
        this.richPresenceImageSmall = simpleDraweeView2;
        this.richPresenceHeader = textView;
        this.richPresenceTitle = textView2;
        this.richPresenceDetails = textView3;
        this.richPresenceTime = textView4;
        this.richPresenceState = textView5;
        this.richPresenceTextContainer = view2;
        this.richPresencePrimaryButton = button;
        this.richPresenceSecondaryButton = button2;
        this.richPresenceType = i;
    }

    public static final /* synthetic */ Subscription access$getPerSecondTimerSubscription$p(ViewHolderUserRichPresence viewHolderUserRichPresence) {
        return viewHolderUserRichPresence.perSecondTimerSubscription;
    }

    public static final /* synthetic */ void access$handleActivityCustomButtonClick(ViewHolderUserRichPresence viewHolderUserRichPresence, Context context, User user, Activity activity, int i) {
        viewHolderUserRichPresence.handleActivityCustomButtonClick(context, user, activity, i);
    }

    public static final /* synthetic */ void access$setPerSecondTimerSubscription$p(ViewHolderUserRichPresence viewHolderUserRichPresence, Subscription subscription) {
        viewHolderUserRichPresence.perSecondTimerSubscription = subscription;
    }

    private final void handleActivityCustomButtonClick(Context applicationContext, User user, Activity activity, int buttonIndex) {
        String sessionId;
        Long applicationId;
        if (user != null) {
            long id2 = user.getId();
            if (activity == null || (sessionId = activity.getSessionId()) == null || (applicationId = activity.getApplicationId()) == null) {
                return;
            }
            long jLongValue = applicationId.longValue();
            Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> function5 = this.onActivityCustomButtonClicked;
            if (function5 != null) {
                function5.invoke(applicationContext, Long.valueOf(id2), sessionId, Long.valueOf(jLongValue), Integer.valueOf(buttonIndex));
            }
        }
    }

    public static /* synthetic */ void setImageAndVisibilityBy$default(ViewHolderUserRichPresence viewHolderUserRichPresence, ImageView imageView, String str, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setImageAndVisibilityBy");
        }
        if ((i & 2) != 0) {
            z2 = false;
        }
        viewHolderUserRichPresence.setImageAndVisibilityBy(imageView, str, z2);
    }

    public static final ViewHolderUserRichPresence setRichPresence(ViewGroup viewGroup, Activity activity, StreamContext streamContext, ViewHolderUserRichPresence viewHolderUserRichPresence) {
        return Companion.setRichPresence(viewGroup, activity, streamContext, viewHolderUserRichPresence);
    }

    @MainThread
    public void configureAssetUi(Activity model, StreamContext streamContext) {
        String str;
        String str2 = null;
        ActivityAssets assets = model != null ? model.getAssets() : null;
        if (assets == null) {
            this.richPresenceImageLarge.setVisibility(8);
            SimpleDraweeView simpleDraweeView = this.richPresenceImageSmall;
            if (simpleDraweeView != null) {
                simpleDraweeView.setVisibility(8);
                return;
            }
            return;
        }
        Long applicationId = model.getApplicationId();
        String largeImage = assets.getLargeImage();
        String assetImage$default = largeImage != null ? IconUtils.getAssetImage$default(IconUtils.INSTANCE, applicationId, largeImage, 0, 4, null) : null;
        String largeText = assets.getLargeText();
        String smallImage = assets.getSmallImage();
        String assetImage$default2 = smallImage != null ? IconUtils.getAssetImage$default(IconUtils.INSTANCE, applicationId, smallImage, 0, 4, null) : null;
        String smallText = assets.getSmallText();
        if (assetImage$default2 == null || assetImage$default != null) {
            str2 = assetImage$default2;
            str = assetImage$default;
        } else {
            str = assetImage$default2;
            largeText = smallText;
            smallText = null;
        }
        setImageAndVisibilityBy$default(this, this.richPresenceImageLarge, str, false, 2, null);
        this.richPresenceImageLarge.setContentDescription(largeText);
        SimpleDraweeView simpleDraweeView2 = this.richPresenceImageSmall;
        if (simpleDraweeView2 != null) {
            setImageAndVisibilityBy(simpleDraweeView2, str2, true);
        }
        SimpleDraweeView simpleDraweeView3 = this.richPresenceImageSmall;
        if (simpleDraweeView3 != null) {
            simpleDraweeView3.setContentDescription(smallText);
        }
    }

    @MainThread
    public void configureCustomButtonsUi(User user, Activity activity, Context applicationContext) {
        m.checkNotNullParameter(applicationContext, "applicationContext");
        List<String> listC = activity != null ? activity.c() : null;
        int i = 0;
        for (Object obj : n.listOf((Object[]) new Button[]{this.richPresencePrimaryButton, this.richPresenceSecondaryButton})) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Button button = (Button) obj;
            String str = listC != null ? (String) u.getOrNull(listC, i) : null;
            if (str != null) {
                if (button != null) {
                    button.setText(str);
                }
                if (button != null) {
                    ViewKt.setVisible(button, true);
                }
                if (button != null) {
                    button.setOnClickListener(new ViewHolderUserRichPresence$configureCustomButtonsUi$$inlined$forEachIndexed$lambda$1(i, this, listC, applicationContext, user, activity));
                }
            } else if (button != null) {
                ViewKt.setVisible(button, false);
            }
            i = i2;
        }
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004a  */
    public void configureTextUi(Activity model, StreamContext streamContext) {
        String string;
        CharSequence charSequenceH;
        Context context;
        if (model == null) {
            return;
        }
        String state = model.getState();
        if (state != null) {
            ActivityParty party = model.getParty();
            if (party != null) {
                PresenceUtils presenceUtils = PresenceUtils.INSTANCE;
                charSequenceH = (presenceUtils.getMaxSize(party) == 0 || (context = this.root.getContext()) == null) ? null : b.h(context, 2131896743, new Object[]{String.valueOf(presenceUtils.getCurrentSize(party)), String.valueOf(presenceUtils.getMaxSize(party))}, null, 4);
                if (charSequenceH == null) {
                    charSequenceH = "";
                }
            } else {
                charSequenceH = "";
            }
            String str = state + ' ' + charSequenceH;
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            string = w.trim(str).toString();
        } else {
            string = null;
        }
        TextView textView = this.richPresenceHeader;
        Context context2 = textView.getContext();
        m.checkNotNullExpressionValue(context2, "richPresenceHeader.context");
        textView.setText(PresenceUtils.getActivityHeader(context2, model));
        this.richPresenceTitle.setText(model.getDetails());
        TextView textView2 = this.richPresenceDetails;
        if (textView2 != null) {
            ViewExtensions.setTextAndVisibilityBy(textView2, string);
        }
        TextView textView3 = this.richPresenceState;
        if (textView3 != null) {
            ActivityAssets assets = model.getAssets();
            ViewExtensions.setTextAndVisibilityBy(textView3, assets != null ? assets.getLargeText() : null);
        }
        TextView textView4 = this.richPresenceTime;
        ActivityTimestamps timestamps = model.getTimestamps();
        ViewExtensions.setTextAndVisibilityBy(textView4, timestamps != null ? friendlyTime(timestamps) : null);
    }

    @MainThread
    public void configureUi(FragmentManager fragmentManager, StreamContext streamContext, boolean isMe, User user, Context applicationContext, ModelRichPresence richPresence, boolean userInSameVoiceChannel) {
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        m.checkNotNullParameter(applicationContext, "applicationContext");
        disposeTimer();
        Activity primaryActivity = richPresence != null ? richPresence.getPrimaryActivity() : null;
        if (streamContext == null && primaryActivity == null) {
            this.root.setVisibility(8);
            return;
        }
        this.root.setVisibility(0);
        configureTextUi(primaryActivity, streamContext);
        this.richPresenceTextContainer.setSelected(true);
        configureAssetUi(primaryActivity, streamContext);
        configureCustomButtonsUi(user, primaryActivity, applicationContext);
    }

    @MainThread
    public void configureUiTimestamp(Activity model, AppComponent appComponent) {
        m.checkNotNullParameter(appComponent, "appComponent");
        if (model != null && this.root.getVisibility() == 0) {
            ActivityTimestamps timestamps = model.getTimestamps();
            if ((timestamps != null ? friendlyTime(timestamps) : null) != null) {
                if (this.perSecondTimerSubscription == null) {
                    Observable<Long> observableE = Observable.E(0L, 1L, TimeUnit.SECONDS);
                    m.checkNotNullExpressionValue(observableE, "Observable\n          .in…0L, 1L, TimeUnit.SECONDS)");
                    ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableE, appComponent, null, 2, null), getClass(), (Context) null, new ViewHolderUserRichPresence$configureUiTimestamp$1(this), (Function1) null, (Function0) null, (Function0) null, new ViewHolderUserRichPresence$configureUiTimestamp$2(this, model), 58, (Object) null);
                    return;
                }
                return;
            }
        }
        disposeTimer();
    }

    public void disposeSubscriptions() {
        disposeTimer();
    }

    @MainThread
    public final void disposeTimer() {
        Subscription subscription = this.perSecondTimerSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        this.perSecondTimerSubscription = null;
    }

    public final CharSequence friendlyTime(ActivityTimestamps activityTimestamps) {
        m.checkNotNullParameter(activityTimestamps, "$this$friendlyTime");
        if (activityTimestamps.b() > 0) {
            return TimeUtils.INSTANCE.toFriendlyString(ClockFactory.get().currentTimeMillis(), activityTimestamps.b(), getString(2131896745), "timeDelta");
        }
        if (activityTimestamps.c() > 0) {
            return TimeUtils.INSTANCE.toFriendlyString(activityTimestamps.c(), ClockFactory.get().currentTimeMillis(), getString(2131896747), "timeDelta");
        }
        return null;
    }

    public final TextView getRichPresenceDetails() {
        return this.richPresenceDetails;
    }

    public final TextView getRichPresenceHeader() {
        return this.richPresenceHeader;
    }

    public final SimpleDraweeView getRichPresenceImageLarge() {
        return this.richPresenceImageLarge;
    }

    public final SimpleDraweeView getRichPresenceImageSmall() {
        return this.richPresenceImageSmall;
    }

    public final Button getRichPresencePrimaryButton() {
        return this.richPresencePrimaryButton;
    }

    public final Button getRichPresenceSecondaryButton() {
        return this.richPresenceSecondaryButton;
    }

    public final TextView getRichPresenceState() {
        return this.richPresenceState;
    }

    public final View getRichPresenceTextContainer() {
        return this.richPresenceTextContainer;
    }

    public final TextView getRichPresenceTime() {
        return this.richPresenceTime;
    }

    public final TextView getRichPresenceTitle() {
        return this.richPresenceTitle;
    }

    public final int getRichPresenceType() {
        return this.richPresenceType;
    }

    public final View getRoot() {
        return this.root;
    }

    public final String getString(@StringRes int stringId) {
        Context context = this.root.getContext();
        if (context != null) {
            return context.getString(stringId);
        }
        return null;
    }

    public final void setImageAndVisibilityBy(ImageView imageView, String str, boolean z2) {
        m.checkNotNullParameter(imageView, "$this$setImageAndVisibilityBy");
        MGImages.setImage$default(imageView, str, 0, 0, z2, null, null, 108, null);
        imageView.setVisibility((str == null || t.isBlank(str)) ^ true ? 0 : 8);
    }

    public final void setOnActivityCustomButtonClicked(Function5<? super Context, ? super Long, ? super String, ? super Long, ? super Integer, Unit> newOnActivityCustomButtonClicked) {
        m.checkNotNullParameter(newOnActivityCustomButtonClicked, "newOnActivityCustomButtonClicked");
        this.onActivityCustomButtonClicked = newOnActivityCustomButtonClicked;
    }

    public void setTimeTextViews(ActivityTimestamps timestamps) {
        ViewExtensions.setTextAndVisibilityBy(this.richPresenceTime, timestamps != null ? friendlyTime(timestamps) : null);
    }

    public /* synthetic */ ViewHolderUserRichPresence(View view, SimpleDraweeView simpleDraweeView, SimpleDraweeView simpleDraweeView2, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, View view2, Button button, Button button2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(view, simpleDraweeView, simpleDraweeView2, textView, textView2, textView3, textView4, textView5, view2, button, button2, (i2 & 2048) != 0 ? 0 : i);
    }
}
