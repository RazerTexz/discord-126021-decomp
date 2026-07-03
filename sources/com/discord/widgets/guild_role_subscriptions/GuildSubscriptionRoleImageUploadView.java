package com.discord.widgets.guild_role_subscriptions;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.api.role.GuildRole;
import com.discord.databinding.ViewGuildRoleSubscriptionImageUploadBinding;
import com.discord.utilities.drawable.DrawableCompat;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import com.facebook.drawee.drawable.ScalingUtils$ScaleType;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p109f.p132g.p142e.C1784r;
import p007b.p109f.p132g.p142e.C1788v;
import p007b.p109f.p132g.p143f.C1795c;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GuildSubscriptionRoleImageUploadView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildSubscriptionRoleImageUploadView extends ConstraintLayout {
    private static final int CIRCLE_IMAGE_STYLE = 0;
    private static final int ROUNDED_IMAGE_STYLE = 1;
    private int avatarSize;
    private final ViewGuildRoleSubscriptionImageUploadBinding binding;
    private Function0<Unit> onImageChooserClickListener;
    private Function0<Unit> onImageRemovedListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
        initialize$default(this, null, 1, null);
    }

    private final void initialize(AttributeSet attrs) {
        ScalingUtils$ScaleType scalingUtils$ScaleType;
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        int[] iArr = C5419R.a.GuildSubscriptionRoleImageUploadView;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.GuildSubscriptionRoleImageUploadView");
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        if (typedArrayObtainStyledAttributes.getBoolean(4, false)) {
            ScalingUtils$ScaleType scalingUtils$ScaleType2 = ScalingUtils$ScaleType.f19495a;
            scalingUtils$ScaleType = C1784r.f3442l;
        } else {
            ScalingUtils$ScaleType scalingUtils$ScaleType3 = ScalingUtils$ScaleType.f19495a;
            scalingUtils$ScaleType = C1788v.f3446l;
        }
        SimpleDraweeView simpleDraweeView = this.binding.f15480d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        GenericDraweeHierarchy hierarchy = simpleDraweeView.getHierarchy();
        C12238m.checkNotNullExpressionValue(hierarchy, "binding.guildSubscriptionImage.hierarchy");
        hierarchy.m8678n(scalingUtils$ScaleType);
        int i = typedArrayObtainStyledAttributes.getInt(2, 0);
        if (i == 0) {
            this.binding.f15480d.setBackgroundResource(DrawableCompat.getThemedDrawableRes(this, C5419R.attr.primary_700_circle, 0));
        } else if (i == 1) {
            SimpleDraweeView simpleDraweeView2 = this.binding.f15480d;
            simpleDraweeView2.setBackgroundResource(C5419R.drawable.drawable_rect_rounded_bg_tertiary);
            GenericDraweeHierarchy hierarchy2 = simpleDraweeView2.getHierarchy();
            C12238m.checkNotNullExpressionValue(hierarchy2, "hierarchy");
            C1795c c1795c = new C1795c();
            c1795c.f3472b = false;
            hierarchy2.m8683s(c1795c);
            C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.guildSubscriptio…            }\n          }");
        }
        String string = typedArrayObtainStyledAttributes.getString(3);
        if (string == null) {
            string = getContext().getString(C5419R.string.guild_role_subscription_tier_detail_custom_image_label);
        }
        C12238m.checkNotNullExpressionValue(string, "it.getString(R.styleable…etail_custom_image_label)");
        TextView textView = this.binding.f15478b;
        C12238m.checkNotNullExpressionValue(textView, "binding.guildSubscriptionCustomImageTitle");
        textView.setText(string);
        String string2 = typedArrayObtainStyledAttributes.getString(0);
        if (string2 == null) {
            string2 = getContext().getString(C5419R.string.guild_role_subscription_tier_detail_custom_image_description);
        }
        C12238m.checkNotNullExpressionValue(string2, "it.getString(R.styleable…image_description\n      )");
        TextView textView2 = this.binding.f15482f;
        C12238m.checkNotNullExpressionValue(textView2, "binding.guildSubscriptionUploadImageLabel");
        textView2.setText(string2);
        this.avatarSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge));
        typedArrayObtainStyledAttributes.recycle();
        this.binding.f15481e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView.initialize.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = GuildSubscriptionRoleImageUploadView.this.onImageChooserClickListener;
                if (function0 != null) {
                }
            }
        });
        this.binding.f15480d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView.initialize.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = GuildSubscriptionRoleImageUploadView.this.onImageChooserClickListener;
                if (function0 != null) {
                }
            }
        });
        this.binding.f15479c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.guild_role_subscriptions.GuildSubscriptionRoleImageUploadView.initialize.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                Function0 function0 = GuildSubscriptionRoleImageUploadView.this.onImageChooserClickListener;
                if (function0 != null) {
                }
            }
        });
    }

    public static /* synthetic */ void initialize$default(GuildSubscriptionRoleImageUploadView guildSubscriptionRoleImageUploadView, AttributeSet attributeSet, int i, Object obj) {
        if ((i & 1) != 0) {
            attributeSet = null;
        }
        guildSubscriptionRoleImageUploadView.initialize(attributeSet);
    }

    private final void updateImageVisibility(boolean hasImage) {
        ImageView imageView = this.binding.f15479c;
        C12238m.checkNotNullExpressionValue(imageView, "binding.guildSubscriptionEditImage");
        imageView.setVisibility(hasImage ? 0 : 8);
        if (hasImage) {
            this.binding.f15481e.setText(C5419R.string.avatar_upload_edit_media);
        } else {
            this.binding.f15481e.setText(C5419R.string.guild_role_subscription_tier_detail_custom_image_button);
        }
    }

    public final void configureUI(Function0<Unit> onImageRemoved, Function0<Unit> onImageChooserClicked) {
        C12238m.checkNotNullParameter(onImageRemoved, "onImageRemoved");
        C12238m.checkNotNullParameter(onImageChooserClicked, "onImageChooserClicked");
        this.onImageRemovedListener = onImageRemoved;
        this.onImageChooserClickListener = onImageChooserClicked;
    }

    public final void updateImage(String memberIcon, GuildRole guildRole) {
        if (!(memberIcon == null || C12103t.isBlank(memberIcon))) {
            updateImage(memberIcon);
            return;
        }
        if (guildRole != null) {
            String icon = guildRole.getIcon();
            if (!(icon == null || C12103t.isBlank(icon))) {
                SimpleDraweeView simpleDraweeView = this.binding.f15480d;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
                IconUtils.setIcon$default(simpleDraweeView, guildRole, C5419R.dimen.avatar_size_huge, (MGImages.ChangeDetector) null, 8, (Object) null);
                updateImageVisibility(true);
                return;
            }
        }
        updateImage((String) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    public final void updateImage(GuildRoleSubscriptionTier guildSubscriptionTier) {
        C12238m.checkNotNullParameter(guildSubscriptionTier, "guildSubscriptionTier");
        String image = guildSubscriptionTier.getImage();
        if ((image == null || C12103t.isBlank(image)) && guildSubscriptionTier.getImageAssetId() != null) {
            updateImage(guildSubscriptionTier.getApplicationId(), guildSubscriptionTier.getImageAssetId().longValue());
        } else {
            updateImage(guildSubscriptionTier.getImage());
        }
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        C12238m.checkNotNullParameter(context, "context");
        ViewGuildRoleSubscriptionImageUploadBinding viewGuildRoleSubscriptionImageUploadBindingM8397a = ViewGuildRoleSubscriptionImageUploadBinding.m8397a(LayoutInflater.from(getContext()), this);
        C12238m.checkNotNullExpressionValue(viewGuildRoleSubscriptionImageUploadBindingM8397a, "ViewGuildRoleSubscriptio…ater.from(context), this)");
        this.binding = viewGuildRoleSubscriptionImageUploadBindingM8397a;
        this.avatarSize = getResources().getDimensionPixelSize(C5419R.dimen.avatar_size_huge);
        initialize(attributeSet);
    }

    private final void updateImage(Long applicationId, long imageAssetId) {
        updateImage(IconUtils.INSTANCE.getStoreAssetImage(applicationId, String.valueOf(imageAssetId), this.avatarSize));
    }

    private final void updateImage(String imageUrl) {
        SimpleDraweeView simpleDraweeView = this.binding.f15480d;
        C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.guildSubscriptionImage");
        int i = this.avatarSize;
        IconUtils.setIcon$default(simpleDraweeView, imageUrl, i, i, false, null, null, 112, null);
        updateImageVisibility(!(imageUrl == null || C12103t.isBlank(imageUrl)));
    }

    public /* synthetic */ GuildSubscriptionRoleImageUploadView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }
}
