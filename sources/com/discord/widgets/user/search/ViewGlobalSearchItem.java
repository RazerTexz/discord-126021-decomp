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
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.databinding.ViewGlobalSearchItemBinding;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.utilities.images.MGImages$ChangeDetector;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ViewGlobalSearchItem.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewGlobalSearchItem extends ConstraintLayout {
    private final ViewGlobalSearchItemBinding binding;

    public ViewGlobalSearchItem(Context context) {
        this(context, null, 0, 6, null);
    }

    public ViewGlobalSearchItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ViewGlobalSearchItem(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    private final CharSequence toStyledText(WidgetGlobalSearchModel$MatchedResult widgetGlobalSearchModel$MatchedResult, String str) {
        if (widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex() < 0) {
            return str;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(widgetGlobalSearchModel$MatchedResult.getValue());
        spannableStringBuilder.setSpan(new StyleSpan(1), widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex(), widgetGlobalSearchModel$MatchedResult.getFilterLength() + widgetGlobalSearchModel$MatchedResult.getFirstMatchIndex(), 17);
        return spannableStringBuilder;
    }

    public final void configure(WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "$this$configure");
        Integer numValueOf = Integer.valueOf(widgetGlobalSearchModel$ItemDataPayload.getMentions());
        if (!(numValueOf.intValue() > 0)) {
            numValueOf = null;
        }
        String strValueOf = numValueOf != null ? String.valueOf(numValueOf.intValue()) : null;
        TextView textView = this.binding.e;
        m.checkNotNullExpressionValue(textView, "binding.itemMentionsTv");
        ViewExtensions.setTextAndVisibilityBy(textView, strValueOf);
        ImageView imageView = this.binding.g;
        m.checkNotNullExpressionValue(imageView, "binding.itemUnread");
        imageView.setVisibility(widgetGlobalSearchModel$ItemDataPayload.getUnread() ? 0 : 8);
    }

    public final void onConfigure(WidgetGlobalSearchModel$ItemChannel data) {
        m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        String str = null;
        simpleDraweeView.setController(null);
        if (ChannelUtils.B(data.getChannel())) {
            SimpleDraweeView simpleDraweeView2 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView2, "binding.itemIconIv");
            IconUtils.setIcon$default(simpleDraweeView2, data.getChannel(), 2131165300, (MGImages$ChangeDetector) null, 8, (Object) null);
        } else if (ChannelUtils.w(data.getChannel())) {
            MGImages mGImages = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView3 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView3, "binding.itemIconIv");
            MGImages.setImage$default(mGImages, simpleDraweeView3, 2131231641, (MGImages$ChangeDetector) null, 4, (Object) null);
        } else if (ChannelUtils.H(data.getChannel())) {
            MGImages mGImages2 = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView4 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView4, "binding.itemIconIv");
            MGImages.setImage$default(mGImages2, simpleDraweeView4, 2131232194, (MGImages$ChangeDetector) null, 4, (Object) null);
        } else {
            MGImages mGImages3 = MGImages.INSTANCE;
            SimpleDraweeView simpleDraweeView5 = this.binding.d;
            m.checkNotNullExpressionValue(simpleDraweeView5, "binding.itemIconIv");
            MGImages.setImage$default(mGImages3, simpleDraweeView5, 2131231632, (MGImages$ChangeDetector) null, 4, (Object) null);
        }
        TextView textView = this.binding.c;
        m.checkNotNullExpressionValue(textView, "binding.itemGroupTv");
        Guild guild = data.getGuild();
        ViewExtensions.setTextAndVisibilityBy(textView, guild != null ? guild.getName() : null);
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
        textView2.setText(toStyledText(data.getMatchedResult(), ChannelUtils.c(data.getChannel())));
        int type = data.getChannel().getType();
        if (type != 0) {
            if (type == 1) {
                TextView textView3 = this.binding.f2189b;
                m.checkNotNullExpressionValue(textView3, "binding.itemDescriptionTv");
                textView3.setVisibility(8);
                TextView textView4 = this.binding.c;
                m.checkNotNullExpressionValue(textView4, "binding.itemGroupTv");
                User userA = ChannelUtils.a(data.getChannel());
                if (userA != null) {
                    str = userA.getUsername() + UserUtils.INSTANCE.getDiscriminatorWithPadding(userA);
                }
                ViewExtensions.setTextAndVisibilityBy(textView4, str);
                return;
            }
            if (type != 2) {
                if (type == 3) {
                    TextView textView5 = this.binding.f2189b;
                    m.checkNotNullExpressionValue(textView5, "binding.itemDescriptionTv");
                    int color = ColorCompat.getColor(textView5, 2131100525);
                    TextView textView6 = this.binding.f2189b;
                    m.checkNotNullExpressionValue(textView6, "binding.itemDescriptionTv");
                    textView6.setText(u.joinToString$default(ChannelUtils.g(data.getChannel()), null, null, null, 0, null, new ViewGlobalSearchItem$onConfigure$2(color), 31, null));
                    TextView textView7 = this.binding.f2189b;
                    m.checkNotNullExpressionValue(textView7, "binding.itemDescriptionTv");
                    textView7.setVisibility(8);
                    TextView textView8 = this.binding.f2189b;
                    m.checkNotNullExpressionValue(textView8, "binding.itemDescriptionTv");
                    textView8.setAllCaps(false);
                    return;
                }
                if (type != 5) {
                    switch (type) {
                    }
                }
            }
        }
        TextView textView9 = this.binding.f2189b;
        m.checkNotNullExpressionValue(textView9, "binding.itemDescriptionTv");
        Channel parentChannel = data.getParentChannel();
        ViewExtensions.setTextAndVisibilityBy(textView9, parentChannel != null ? ChannelUtils.c(parentChannel) : null);
        TextView textView10 = this.binding.f2189b;
        m.checkNotNullExpressionValue(textView10, "binding.itemDescriptionTv");
        textView10.setAllCaps(true);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewGlobalSearchItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m.checkNotNullParameter(context, "ctx");
        LayoutInflater.from(context).inflate(R$layout.view_global_search_item, this);
        int i2 = 2131363590;
        Guideline guideline = (Guideline) findViewById(2131363590);
        if (guideline != null) {
            i2 = R$id.item_description_tv;
            TextView textView = (TextView) findViewById(R$id.item_description_tv);
            if (textView != null) {
                i2 = R$id.item_group_tv;
                TextView textView2 = (TextView) findViewById(R$id.item_group_tv);
                if (textView2 != null) {
                    i2 = R$id.item_icon_iv;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) findViewById(R$id.item_icon_iv);
                    if (simpleDraweeView != null) {
                        i2 = R$id.item_mentions_tv;
                        TextView textView3 = (TextView) findViewById(R$id.item_mentions_tv);
                        if (textView3 != null) {
                            i2 = R$id.item_name_tv;
                            TextView textView4 = (TextView) findViewById(R$id.item_name_tv);
                            if (textView4 != null) {
                                i2 = R$id.item_unread;
                                ImageView imageView = (ImageView) findViewById(R$id.item_unread);
                                if (imageView != null) {
                                    ViewGlobalSearchItemBinding viewGlobalSearchItemBinding = new ViewGlobalSearchItemBinding(this, guideline, textView, textView2, simpleDraweeView, textView3, textView4, imageView);
                                    m.checkNotNullExpressionValue(viewGlobalSearchItemBinding, "ViewGlobalSearchItemBind…Inflater.from(ctx), this)");
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

    public final void onConfigure(WidgetGlobalSearchModel$ItemGuild data) {
        m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, IconUtils.getForGuild$default(data.getGuild(), IconUtils.DEFAULT_ICON, false, null, 12, null), 0, (Function1) null, (MGImages$ChangeDetector) null, 28, (Object) null);
        TextView textView = this.binding.f;
        m.checkNotNullExpressionValue(textView, "binding.itemNameTv");
        textView.setText(toStyledText(data.getMatchedResult(), data.getGuild().getName()));
        TextView textView2 = this.binding.c;
        m.checkNotNullExpressionValue(textView2, "binding.itemGroupTv");
        ViewExtensions.setTextAndVisibilityBy(textView2, null);
        TextView textView3 = this.binding.f2189b;
        m.checkNotNullExpressionValue(textView3, "binding.itemDescriptionTv");
        ViewExtensions.setTextAndVisibilityBy(textView3, null);
    }

    public final void onConfigure(WidgetGlobalSearchModel$ItemUser data) {
        m.checkNotNullParameter(data, "data");
        configure(data);
        SimpleDraweeView simpleDraweeView = this.binding.d;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.itemIconIv");
        IconUtils.setIcon$default(simpleDraweeView, data.getUser(), 0, null, null, null, 60, null);
        if (data.isFriend()) {
            this.binding.c.setText(2131889471);
        } else {
            TextView textView = this.binding.c;
            m.checkNotNullExpressionValue(textView, "binding.itemGroupTv");
            textView.setText((CharSequence) null);
        }
        TextView textView2 = this.binding.f;
        m.checkNotNullExpressionValue(textView2, "binding.itemNameTv");
        textView2.setText(toStyledText(data.getMatchedResult(), data.getMatchedResult().getValue().toString()));
        TextView textView3 = this.binding.f;
        m.checkNotNullExpressionValue(textView3, "binding.itemNameTv");
        textView3.setImportantForAccessibility(2);
        TextView textView4 = this.binding.c;
        m.checkNotNullExpressionValue(textView4, "binding.itemGroupTv");
        ViewExtensions.setTextAndVisibilityBy(textView4, (CharSequence) u.firstOrNull((List) data.getAliases()));
        TextView textView5 = this.binding.f2189b;
        m.checkNotNullExpressionValue(textView5, "binding.itemDescriptionTv");
        textView5.setAllCaps(false);
        TextView textView6 = this.binding.f2189b;
        m.checkNotNullExpressionValue(textView6, "binding.itemDescriptionTv");
        List listDrop = u.drop(data.getAliases(), 1);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listDrop) {
            if (!m.areEqual((CharSequence) obj, data.getMatchedResult().getValue())) {
                arrayList.add(obj);
            }
        }
        ViewExtensions.setTextAndVisibilityBy(textView6, u.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null));
    }
}
