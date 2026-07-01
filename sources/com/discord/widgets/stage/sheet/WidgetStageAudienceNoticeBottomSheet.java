package com.discord.widgets.stage.sheet;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.stageinstance.StageInstance;
import com.discord.api.stageinstance.StageInstancePrivacyLevel;
import com.discord.app.AppBottomSheet;
import com.discord.databinding.WidgetStageAudienceNoticeBottomSheetBinding;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet extends AppBottomSheet {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetStageAudienceNoticeBottomSheet.class, "binding", "getBinding()Lcom/discord/databinding/WidgetStageAudienceNoticeBottomSheetBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: channelId$delegate, reason: from kotlin metadata */
    private final Lazy channelId;

    /* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void show(FragmentManager fragmentManager, long channelId) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            WidgetStageAudienceNoticeManager widgetStageAudienceNoticeManager = WidgetStageAudienceNoticeManager.INSTANCE;
            if (widgetStageAudienceNoticeManager.hasUserSeenAudienceNotice()) {
                return;
            }
            widgetStageAudienceNoticeManager.markUserSeenAudienceNotice();
            WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet = new WidgetStageAudienceNoticeBottomSheet();
            Bundle bundle = new Bundle();
            bundle.putLong("com.discord.intent.extra.EXTRA_CHANNEL_ID", channelId);
            widgetStageAudienceNoticeBottomSheet.setArguments(bundle);
            widgetStageAudienceNoticeBottomSheet.show(fragmentManager, WidgetStageAudienceNoticeBottomSheet.class.getSimpleName());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet$onResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StageInstance, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StageInstance stageInstance) {
            invoke2(stageInstance);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StageInstance stageInstance) {
            WidgetStageAudienceNoticeBottomSheet.this.configureUI(stageInstance);
        }
    }

    public WidgetStageAudienceNoticeBottomSheet() {
        super(false, 1, null);
        this.channelId = LazyJVM.lazy(new WidgetStageAudienceNoticeBottomSheet3(this));
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetStageAudienceNoticeBottomSheet2.INSTANCE, null, 2, null);
    }

    private final void configureUI(StageInstance stageInstance) {
        boolean z2 = (stageInstance != null ? stageInstance.getPrivacyLevel() : null) == StageInstancePrivacyLevel.PUBLIC;
        ImageView imageView = getBinding().f2648b;
        Intrinsics3.checkNotNullExpressionValue(imageView, "binding.bullet4Icon");
        imageView.setVisibility(z2 ? 0 : 8);
        TextView textView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.bullet4Label");
        textView.setVisibility(z2 ? 0 : 8);
    }

    private final WidgetStageAudienceNoticeBottomSheetBinding getBinding() {
        return (WidgetStageAudienceNoticeBottomSheetBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getChannelId() {
        return ((Number) this.channelId.getValue()).longValue();
    }

    @Override // com.discord.app.AppBottomSheet
    public int getContentViewResId() {
        return R.layout.widget_stage_audience_notice_bottom_sheet;
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(StoreStream.INSTANCE.getStageInstances().observeStageInstanceForChannel(getChannelId()), this, null, 2, null), (Class<?>) WidgetStageAudienceNoticeBottomSheet.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }

    @Override // com.discord.app.AppBottomSheet, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        WidgetStageAudienceNoticeBottomSheetBinding binding = getBinding();
        Intrinsics3.checkNotNullExpressionValue(binding, "binding");
        setPeekHeightBottomView(binding.a);
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.stage.sheet.WidgetStageAudienceNoticeBottomSheet.onViewCreated.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetStageAudienceNoticeBottomSheet.this.dismiss();
            }
        });
    }
}
