package com.discord.widgets.user.search;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGlobalSearchItemBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ViewGlobalSearchItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGlobalSearchItem extends ConstraintLayout {
    private final ViewGlobalSearchItemBinding binding;

    /* JADX INFO: renamed from: com.discord.widgets.user.search.ViewGlobalSearchItem$onConfigure$2 */
    /* JADX INFO: compiled from: ViewGlobalSearchItem.kt */
    public static final class C103142 extends AbstractC12240o implements Function1<User, CharSequence> {
        public final /* synthetic */ int $discrimColor;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C103142(int i) {
            super(1);
            this.$discrimColor = i;
        }

        @Override // kotlin.jvm.functions.Function1
        public final CharSequence invoke(User user) {
            C12238m.checkNotNullParameter(user, "user");
            return UserUtils.INSTANCE.getUserNameWithDiscriminator(user, Integer.valueOf(this.$discrimColor), Float.valueOf(0.75f));
        }
    }

    public ViewGlobalSearchItem(Context context) {
        this(context, null, 0, 6, null);
    }

    public ViewGlobalSearchItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ViewGlobalSearchItem(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final CharSequence toStyledText(WidgetGlobalSearchModel.MatchedResult matchedResult, String str) {
        if (matchedResult.getFirstMatchIndex() < 0) {
            return str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(matchedResult.getValue());
        spannableStringBuilder.setSpan(new StyleSpan(1), matchedResult.getFirstMatchIndex(), matchedResult.getFilterLength() + matchedResult.getFirstMatchIndex(), 17);
        return spannableStringBuilder;
    }

    public final void configure(WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        C12238m.checkNotNullParameter(itemDataPayload, "$this$configure");
        Integer numValueOf = Integer.valueOf(itemDataPayload.getMentions());
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        String strValueOf = numValueOf != null ? String.valueOf(numValueOf.intValue()) : null;
        TextView textView = this.binding.f15449e;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemMentionsTv");
        ViewExtensions.setTextAndVisibilityBy(textView, strValueOf);
        ImageView imageView = this.binding.f15451g;
        C12238m.checkNotNullExpressionValue(imageView, "binding.itemUnread");
        imageView.setVisibility(itemDataPayload.getUnread() ? 0 : 8);
    }

    public final void onConfigure(WidgetGlobalSearchModel.ItemChannel data) {
        C12238m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.f15448d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        String str = null;
        simpleDraweeView.setController(null);
        if (ChannelUtils.m7667B(data.getChannel())) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f15448d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView2, data.getChannel(), C5419R.dimen.avatar_size_standard, (MGImages.ChangeDetector) null, 8, (Object) null);
        } else if (ChannelUtils.m7699w(data.getChannel())) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView3 = this.binding.f15448d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
            MGImages.setImage$default(mGImages, simpleDraweeView3, C5419R.drawable.ic_channel_voice_grey_18dp, (MGImages.ChangeDetector) null, 4, (Object) null);
        } else if (ChannelUtils.m7673H(data.getChannel())) {
            MGImages mGImages2 = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView4 = this.binding.f15448d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemIconIv");
            MGImages.setImage$default(mGImages2, simpleDraweeView4, C5419R.drawable.ic_thread_grey_18dp, (MGImages.ChangeDetector) null, 4, (Object) null);
        } else {
            MGImages mGImages3 = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView5 = this.binding.f15448d;
            C12238m.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemIconIv");
            MGImages.setImage$default(mGImages3, simpleDraweeView5, C5419R.drawable.ic_channel_text_grey_18dp, (MGImages.ChangeDetector) null, 4, (Object) null);
        }
        TextView textView = this.binding.f15447c;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemGroupTv");
        Guild guild = data.getGuild();
        ViewExtensions.setTextAndVisibilityBy(textView, guild != null ? guild.getName() : null);
        TextView textView2 = this.binding.f15450f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
        textView2.setText(toStyledText(data.getMatchedResult(), ChannelUtils.m7679c(data.getChannel())));
        int type = data.getChannel().getType();
        if (type != 0) {
            if (type == 1) {
                TextView textView3 = this.binding.f15446b;
                C12238m.checkNotNullExpressionValue(textView3, "binding.itemDescriptionTv");
                textView3.setVisibility(8);
                TextView textView4 = this.binding.f15447c;
                C12238m.checkNotNullExpressionValue(textView4, "binding.itemGroupTv");
                User userM7677a = ChannelUtils.m7677a(data.getChannel());
                if (userM7677a != null) {
                    str = userM7677a.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(userM7677a);
                }
                ViewExtensions.setTextAndVisibilityBy(textView4, str);
                return;
            }
            if (type != 2) {
                if (type == 3) {
                    TextView textView5 = this.binding.f15446b;
                    C12238m.checkNotNullExpressionValue(textView5, "binding.itemDescriptionTv");
                    int color = ColorCompat.getColor(textView5, C5419R.color.white_alpha_40);
                    TextView textView6 = this.binding.f15446b;
                    C12238m.checkNotNullExpressionValue(textView6, "binding.itemDescriptionTv");
                    textView6.setText(C12163u.joinToString$default(ChannelUtils.m7683g(data.getChannel()), null, null, null, 0, null, new C103142(color), 31, null));
                    TextView textView7 = this.binding.f15446b;
                    C12238m.checkNotNullExpressionValue(textView7, "binding.itemDescriptionTv");
                    textView7.setVisibility(8);
                    TextView textView8 = this.binding.f15446b;
                    C12238m.checkNotNullExpressionValue(textView8, "binding.itemDescriptionTv");
                    textView8.setAllCaps(false);
                    return;
                }
                if (type != 5) {
                    switch (type) {
                    }
                }
            }
        }
        TextView textView9 = this.binding.f15446b;
        C12238m.checkNotNullExpressionValue(textView9, "binding.itemDescriptionTv");
        Channel parentChannel = data.getParentChannel();
        ViewExtensions.setTextAndVisibilityBy(textView9, parentChannel != null ? ChannelUtils.m7679c(parentChannel) : null);
        TextView textView10 = this.binding.f15446b;
        C12238m.checkNotNullExpressionValue(textView10, "binding.itemDescriptionTv");
        textView10.setAllCaps(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGlobalSearchItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "ctx");
        LayoutInflater.from(context).inflate(C5419R.layout.view_global_search_item, this);
        int i2 = C5419R.id.guideline;
        Guideline guideline = (Guideline) findViewById(C5419R.id.guideline);
        if (guideline != null) {
            i2 = C5419R.id.item_description_tv;
            TextView textView = (TextView) findViewById(C5419R.id.item_description_tv);
            if (textView != null) {
                i2 = C5419R.id.item_group_tv;
                TextView textView2 = (TextView) findViewById(C5419R.id.item_group_tv);
                if (textView2 != null) {
                    i2 = C5419R.id.item_icon_iv;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(C5419R.id.item_icon_iv);
                    if (simpleDraweeView != null) {
                        i2 = C5419R.id.item_mentions_tv;
                        TextView textView3 = (TextView) findViewById(C5419R.id.item_mentions_tv);
                        if (textView3 != null) {
                            i2 = C5419R.id.item_name_tv;
                            TextView textView4 = (TextView) findViewById(C5419R.id.item_name_tv);
                            if (textView4 != null) {
                                i2 = C5419R.id.item_unread;
                                ImageView imageView = (ImageView) findViewById(C5419R.id.item_unread);
                                if (imageView != null) {
                                    ViewGlobalSearchItemBinding viewGlobalSearchItemBinding = new ViewGlobalSearchItemBinding(this, guideline, textView, textView2, simpleDraweeView, textView3, textView4, imageView);
                                    C12238m.checkNotNullExpressionValue(viewGlobalSearchItemBinding, "ViewGlobalSearchItemBind…Inflater.from(ctx), this)");
                                    this.binding = viewGlobalSearchItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }

    public final void onConfigure(WidgetGlobalSearchModel.ItemGuild data) {
        C12238m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.f15448d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(data.getGuild(), IconUtils.DEFAULT_ICON, false, null, 12, null), 0, (Function1) null, (MGImages.ChangeDetector) null, 28, (Object) null);
        TextView textView = this.binding.f15450f;
        C12238m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
        textView.setText(toStyledText(data.getMatchedResult(), data.getGuild().getName()));
        TextView textView2 = this.binding.f15447c;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemGroupTv");
        ViewExtensions.setTextAndVisibilityBy(textView2, null);
        TextView textView3 = this.binding.f15446b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemDescriptionTv");
        ViewExtensions.setTextAndVisibilityBy(textView3, null);
    }

    public final void onConfigure(WidgetGlobalSearchModel.ItemUser data) {
        C12238m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.f15448d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, data.getUser(), 0, null, null, null, 60, null);
        if (data.isFriend()) {
            this.binding.f15447c.setText(C5419R.string.friends);
        } else {
            TextView textView = this.binding.f15447c;
            C12238m.checkNotNullExpressionValue(textView, "binding.itemGroupTv");
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.binding.f15450f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
        textView2.setText(toStyledText(data.getMatchedResult(), data.getMatchedResult().getValue().toString()));
        TextView textView3 = this.binding.f15450f;
        C12238m.checkNotNullExpressionValue(textView3, "binding.itemNameTv");
        textView3.setImportantForAccessibility(2);
        TextView textView4 = this.binding.f15447c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.itemGroupTv");
        ViewExtensions.setTextAndVisibilityBy(textView4, (CharSequence) C12163u.firstOrNull((List) data.getAliases()));
        TextView textView5 = this.binding.f15446b;
        C12238m.checkNotNullExpressionValue(textView5, "binding.itemDescriptionTv");
        textView5.setAllCaps(false);
        TextView textView6 = this.binding.f15446b;
        C12238m.checkNotNullExpressionValue(textView6, "binding.itemDescriptionTv");
        List listDrop = C12163u.drop(data.getAliases(), 1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listDrop) {
            if (!C12238m.areEqual((CharSequence) obj, data.getMatchedResult().getValue())) {
                arrayList.add(obj);
            }
        }
        ViewExtensions.setTextAndVisibilityBy(textView6, C12163u.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
    }
}
