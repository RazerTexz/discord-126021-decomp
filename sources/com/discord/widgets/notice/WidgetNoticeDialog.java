package com.discord.widgets.notice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources$Theme;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.LayoutRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetNoticeDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNotices$Dialog$Type;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.google.android.material.button.MaterialButton;
import d0.g0.t;
import d0.z.d.m;
import java.io.Serializable;
import java.util.Map;
import java.util.Map$Entry;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetNoticeDialog.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetNoticeDialog extends AppDialog {
    private static final String ARG_ABOVE_LAYOUT_ID = "above_layout_id";
    private static final String ARG_BELOW_LAYOUT_ID = "below_layout_id";
    private static final String ARG_BODY_TEXT = "body_text";
    private static final String ARG_BODY_TEXT_ALIGNMENT = "body_text_alignment";
    private static final String ARG_CANCELABLE = "cancelable";
    private static final String ARG_CANCEL_TEXT = "cancel_text";
    private static final String ARG_HEADER_TEXT = "header_text";
    private static final String ARG_NOTICE_TYPE = "notice_type";
    private static final String ARG_OK_TEXT = "ok_text";
    private static final String ARG_STACK_TRACE_CALLER_FRAME = "stack_trace_caller_frame";
    private static final String ARG_THEME_ID = "theme_id";
    public static final int CANCEL_BUTTON = 2131364550;
    public static final int OK_BUTTON = 2131364555;
    public static final int ON_SHOW = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private Map<Integer, ? extends Function1<? super View, Unit>> listenerMap;
    private Function0<Unit> onDismiss;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetNoticeDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeDialogBinding;", 0)};
    public static final WidgetNoticeDialog$Companion Companion = new WidgetNoticeDialog$Companion(null);

    public WidgetNoticeDialog() {
        super(R$layout.widget_notice_dialog);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetNoticeDialog$binding$2.INSTANCE, null, 2, null);
    }

    private final WidgetNoticeDialogBinding getBinding() {
        return (WidgetNoticeDialogBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final Integer insertLayoutInBundle(Bundle bundle, String str, int i) {
        if (bundle == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(bundle.getInt(str));
        if (!(numValueOf.intValue() != 0)) {
            numValueOf = null;
        }
        if (numValueOf == null) {
            return null;
        }
        getBinding().f2500b.addView(getLayoutInflater().inflate(numValueOf.intValue(), (ViewGroup) getBinding().f2500b, false), i);
        return numValueOf;
    }

    public static /* synthetic */ Integer insertLayoutInBundle$default(WidgetNoticeDialog widgetNoticeDialog, Bundle bundle, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return widgetNoticeDialog.insertLayoutInBundle(bundle, str, i);
    }

    public static final void show(FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, StoreNotices$Dialog$Type storeNotices$Dialog$Type, @LayoutRes Integer num, @LayoutRes Integer num2, Integer num3, Boolean bool, String str, int i, Function0<Unit> function0) {
        Companion.show(fragmentManager, charSequence, charSequence2, charSequence3, charSequence4, map, storeNotices$Dialog$Type, num, num2, num3, bool, str, i, function0);
    }

    public final Map<Integer, Function1<View, Unit>> getListenerMap() {
        return this.listenerMap;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void logOnStartError(Exception exception) {
        m.checkNotNullParameter(exception, "exception");
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(ARG_STACK_TRACE_CALLER_FRAME) : null;
        Logger.e$default(AppLog.g, "failed to start WidgetNoticeDialog from " + serializable, exception, null, 4, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources$Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, 2130969241), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface$OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        m.checkNotNullParameter(dialog, "dialog");
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        super.onDismiss(dialog);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(View view) {
        Map<Integer, ? extends Function1<? super View, Unit>> map;
        Function1<? super View, Unit> function1;
        String string;
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        setCancelable(arguments != null ? arguments.getBoolean(ARG_CANCELABLE, true) : true);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(ARG_NOTICE_TYPE)) != null) {
            StoreNotices notices = StoreStream.Companion.getNotices();
            m.checkNotNullExpressionValue(string, "it");
            notices.markDialogSeen(string);
        }
        Bundle arguments3 = getArguments();
        CharSequence charSequence = arguments3 != null ? arguments3.getCharSequence(ARG_HEADER_TEXT) : null;
        TextView textView = getBinding().e;
        m.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        textView.setText(charSequence);
        LinearLayout linearLayout = getBinding().f;
        m.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility((charSequence == null || t.isBlank(charSequence)) ^ true ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        Bundle arguments4 = getArguments();
        linkifiedTextView.setText(arguments4 != null ? arguments4.getCharSequence(ARG_BODY_TEXT) : null);
        if (isCancelable()) {
            LinkifiedTextView linkifiedTextView2 = getBinding().c;
            m.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
            linkifiedTextView2.setMovementMethod(new WidgetNoticeDialog$ActionLinkMovementMethod(new WidgetNoticeDialog$onViewBound$2(this)));
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().c;
        m.checkNotNullExpressionValue(linkifiedTextView3, "binding.noticeBodyText");
        Bundle arguments5 = getArguments();
        linkifiedTextView3.setTextAlignment(arguments5 != null ? arguments5.getInt(ARG_BODY_TEXT_ALIGNMENT) : 2);
        MaterialButton materialButton = getBinding().g;
        m.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        Bundle arguments6 = getArguments();
        ViewExtensions.setTextAndVisibilityBy(materialButton, arguments6 != null ? arguments6.getCharSequence(ARG_OK_TEXT) : null);
        Bundle arguments7 = getArguments();
        CharSequence charSequence2 = arguments7 != null ? arguments7.getCharSequence(ARG_CANCEL_TEXT) : null;
        MaterialButton materialButton2 = getBinding().d;
        m.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, charSequence2);
        Bundle arguments8 = getArguments();
        if (arguments8 != null) {
            insertLayoutInBundle(arguments8, ARG_ABOVE_LAYOUT_ID, 0);
        }
        Bundle arguments9 = getArguments();
        if (arguments9 != null) {
            LinearLayout linearLayout2 = getBinding().f2500b;
            m.checkNotNullExpressionValue(linearLayout2, "binding.noticeBodyContainer");
            insertLayoutInBundle(arguments9, ARG_BELOW_LAYOUT_ID, linearLayout2.getChildCount());
        }
        getBinding().g.setOnClickListener(new WidgetNoticeDialog$onViewBound$4(this));
        getBinding().d.setOnClickListener(new WidgetNoticeDialog$onViewBound$5(this));
        Map<Integer, ? extends Function1<? super View, Unit>> map2 = this.listenerMap;
        if (map2 != null) {
            for (Map$Entry<Integer, ? extends Function1<? super View, Unit>> map$Entry : map2.entrySet()) {
                View viewFindViewById = view.findViewById(map$Entry.getKey().intValue());
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1(map$Entry, this, view));
                }
            }
        }
        if (getContext() == null || (map = this.listenerMap) == null || (function1 = map.get(0)) == null) {
            return;
        }
        function1.invoke(view);
    }

    public final void setListenerMap(Map<Integer, ? extends Function1<? super View, Unit>> map) {
        this.listenerMap = map;
    }

    public final void setOnDismiss(Function0<Unit> function0) {
        this.onDismiss = function0;
    }
}
