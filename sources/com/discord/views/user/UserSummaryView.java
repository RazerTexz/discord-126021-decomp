package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import b.a.i.ViewUserSummaryItemBinding;
import com.discord.R;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserSummaryView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserSummaryView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final CutoutView.a.c cutoutStyle;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarSizePx;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int overlapAmountPx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public List<UserGuildMember> members;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int maxAvatars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.cutoutStyle = new CutoutView.a.c(0);
        Resources resources = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources, "resources");
        this.avatarSizePx = (int) (16 * resources.getDisplayMetrics().density);
        Resources resources2 = getResources();
        Intrinsics3.checkNotNullExpressionValue(resources2, "resources");
        this.overlapAmountPx = (int) (4 * resources2.getDisplayMetrics().density);
        this.members = Collections2.emptyList();
        this.maxAvatars = 3;
        int[] iArr = R.a.UserSummaryView;
        Intrinsics3.checkNotNullExpressionValue(iArr, "R.styleable.UserSummaryView");
        Context context2 = getContext();
        Intrinsics3.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        Intrinsics3.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.avatarSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.avatarSizePx);
        this.overlapAmountPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.overlapAmountPx);
        this.maxAvatars = typedArrayObtainStyledAttributes.getInt(2, this.maxAvatars);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void b(UserSummaryView userSummaryView, List list, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        userSummaryView.a(list, z2);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a(List<UserGuildMember> members, boolean withFullAvatarAtEnd) {
        int id2;
        Intrinsics3.checkNotNullParameter(members, "members");
        if (!Intrinsics3.areEqual(members, this.members)) {
            this.members = members;
            int iCoerceAtMost = _Ranges.coerceAtMost(members.size(), this.maxAvatars);
            while (getChildCount() > iCoerceAtMost) {
                removeViewAt(getChildCount() - 1);
            }
            while (true) {
                id2 = 0;
                if (getChildCount() >= iCoerceAtMost) {
                    break;
                }
                int childCount = getChildCount();
                ViewUserSummaryItemBinding viewUserSummaryItemBindingA = ViewUserSummaryItemBinding.a(LayoutInflater.from(getContext()).inflate(R.layout.view_user_summary_item, (ViewGroup) this, false));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingA, "ViewUserSummaryItemBindi…ext), this, false\n      )");
                CutoutView cutoutView = viewUserSummaryItemBindingA.a;
                cutoutView.setId(childCount + 10);
                int i = this.avatarSizePx;
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i);
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.setMarginStart(childCount != 0 ? this.avatarSizePx - this.overlapAmountPx : 0);
                if (childCount != 0) {
                    id2 = cutoutView.getId() - 1;
                }
                layoutParams.startToStart = id2;
                cutoutView.setLayoutParams(layoutParams);
                Intrinsics3.checkNotNullExpressionValue(cutoutView, "ViewUserSummaryItemBindi…      }\n        }\n      }");
                addView(cutoutView, cutoutView.getLayoutParams());
            }
            int i2 = iCoerceAtMost - 1;
            while (id2 < iCoerceAtMost) {
                ViewUserSummaryItemBinding viewUserSummaryItemBindingA2 = ViewUserSummaryItemBinding.a(getChildAt(id2));
                Intrinsics3.checkNotNullExpressionValue(viewUserSummaryItemBindingA2, "ViewUserSummaryItemBinding.bind(getChildAt(i))");
                viewUserSummaryItemBindingA2.a.setStyle((id2 == i2 && withFullAvatarAtEnd) ? CutoutView.a.d.a : this.cutoutStyle);
                int mediaProxySize = IconUtils.getMediaProxySize(this.avatarSizePx);
                UserGuildMember userGuildMember = this.members.get(id2);
                String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(mediaProxySize), false, 8, null);
                SimpleDraweeView simpleDraweeView = viewUserSummaryItemBindingA2.f113b;
                Intrinsics3.checkNotNullExpressionValue(simpleDraweeView, "cutout.avatar");
                if (!Intrinsics3.areEqual(forGuildMemberOrUser$default, simpleDraweeView.getTag())) {
                    SimpleDraweeView simpleDraweeView2 = viewUserSummaryItemBindingA2.f113b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView2, "cutout.avatar");
                    simpleDraweeView2.setTag(forGuildMemberOrUser$default);
                    SimpleDraweeView simpleDraweeView3 = viewUserSummaryItemBindingA2.f113b;
                    Intrinsics3.checkNotNullExpressionValue(simpleDraweeView3, "cutout.avatar");
                    IconUtils.setIcon$default(simpleDraweeView3, forGuildMemberOrUser$default, R.dimen.avatar_size_reply, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                }
                id2++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            int i = 2;
            String str = null;
            boolean z2 = false;
            DefaultConstructorMarker defaultConstructorMarker = null;
            a(Collections2.listOf((Object[]) new UserGuildMember[]{new UserGuildMember(new CoreUser(0L, "mreynolds", null, str, false, z2, 0, null, 0, 0, null, null, 4092, defaultConstructorMarker), null, i, 0 == true ? 1 : 0), new UserGuildMember(new CoreUser(1L, "itskaylee", str, null, z2, 0 == true ? 1 : 0, 0, null, 0, 0, null, null, 4092, defaultConstructorMarker), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0)}), true);
        }
    }
}
