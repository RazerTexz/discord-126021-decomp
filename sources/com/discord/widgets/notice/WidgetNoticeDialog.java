package com.discord.widgets.notice;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.AttrRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.StringRes;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppActivity;
import com.discord.app.AppDialog;
import com.discord.app.AppLog;
import com.discord.databinding.WidgetNoticeDialogBinding;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.g0.StringsJVM;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetNoticeDialog.class, "binding", "getBinding()Lcom/discord/databinding/WidgetNoticeDialogBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetNoticeDialog.kt */
    public static final class ActionLinkMovementMethod extends LinkMovementMethod {
        private final Function0<Unit> linkAction;

        public ActionLinkMovementMethod(Function0<Unit> function0) {
            Intrinsics3.checkNotNullParameter(function0, "linkAction");
            this.linkAction = function0;
        }

        @Override // android.text.method.LinkMovementMethod, android.text.method.ScrollingMovementMethod, android.text.method.BaseMovementMethod, android.text.method.MovementMethod
        public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
            Intrinsics3.checkNotNullParameter(widget, "widget");
            Intrinsics3.checkNotNullParameter(buffer, "buffer");
            Intrinsics3.checkNotNullParameter(event, "event");
            boolean zOnTouchEvent = super.onTouchEvent(widget, buffer, event);
            if (event.getAction() == 1) {
                this.linkAction.invoke();
            }
            return zOnTouchEvent;
        }
    }

    /* JADX INFO: compiled from: WidgetNoticeDialog.kt */
    public static final class Builder {
        private String cancelText;
        private String confirmText;
        private final Context context;
        private boolean isCancelable;
        private CharSequence message;
        private Function1<? super View, Unit> onCancel;
        private Function1<? super View, Unit> onConfirm;
        private String tag;
        private Integer themeId;
        private CharSequence title;

        public Builder(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            this.context = context;
            this.title = "";
            this.message = "";
            this.confirmText = "";
            this.cancelText = "";
            this.onConfirm = WidgetNoticeDialog$Builder$onConfirm$1.INSTANCE;
            this.onCancel = WidgetNoticeDialog$Builder$onCancel$1.INSTANCE;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setNegativeButton$1.INSTANCE;
            }
            return builder.setNegativeButton(str, (Function1<? super View, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, String str, Function1 function1, int i, Object obj) {
            if ((i & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setPositiveButton$1.INSTANCE;
            }
            return builder.setPositiveButton(str, (Function1<? super View, Unit>) function1);
        }

        public final Context getContext() {
            return this.context;
        }

        public final Builder setCancelable(boolean cancelable) {
            this.isCancelable = cancelable;
            return this;
        }

        public final Builder setDialogAttrTheme(@AttrRes int theme) {
            this.themeId = Integer.valueOf(theme);
            return this;
        }

        public final Builder setMessage(CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.message = text;
            return this;
        }

        public final Builder setNegativeButton(String text, Function1<? super View, Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(onCancel, "onCancel");
            this.cancelText = text;
            this.onCancel = onCancel;
            return this;
        }

        public final Builder setPositiveButton(String text, Function1<? super View, Unit> onConfirm) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            Intrinsics3.checkNotNullParameter(onConfirm, "onConfirm");
            this.confirmText = text;
            this.onConfirm = onConfirm;
            return this;
        }

        public final Builder setTag(String tag) {
            Intrinsics3.checkNotNullParameter(tag, "tag");
            this.tag = tag;
            return this;
        }

        public final Builder setTitle(CharSequence text) {
            Intrinsics3.checkNotNullParameter(text, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
            this.title = text;
            return this;
        }

        public final void show(FragmentManager fragmentManager) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Companion.show$default(WidgetNoticeDialog.INSTANCE, fragmentManager, this.title, this.message, this.confirmText, this.cancelText, Maps6.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), this.onConfirm), Tuples.to(Integer.valueOf(R.id.notice_cancel), this.onCancel)), null, null, null, this.themeId, null, null, 0, null, 15808, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setNegativeButton$default(Builder builder, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setNegativeButton$2.INSTANCE;
            }
            return builder.setNegativeButton(i, (Function1<? super View, Unit>) function1);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ Builder setPositiveButton$default(Builder builder, int i, Function1 function1, int i2, Object obj) {
            if ((i2 & 2) != 0) {
                function1 = WidgetNoticeDialog$Builder$setPositiveButton$2.INSTANCE;
            }
            return builder.setPositiveButton(i, (Function1<? super View, Unit>) function1);
        }

        public final Builder setMessage(@StringRes int stringResId) {
            this.message = FormatUtils.b(this.context, stringResId, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            return this;
        }

        public final Builder setTitle(@StringRes int stringResId) {
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.title = string;
            return this;
        }

        public final Builder setNegativeButton(@StringRes int stringResId, Function1<? super View, Unit> onCancel) {
            Intrinsics3.checkNotNullParameter(onCancel, "onCancel");
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.cancelText = string;
            this.onCancel = onCancel;
            return this;
        }

        public final Builder setPositiveButton(@StringRes int stringResId, Function1<? super View, Unit> onConfirm) {
            Intrinsics3.checkNotNullParameter(onConfirm, "onConfirm");
            String string = this.context.getString(stringResId);
            Intrinsics3.checkNotNullExpressionValue(string, "context.getString(stringResId)");
            this.confirmText = string;
            this.onConfirm = onConfirm;
            return this;
        }
    }

    /* JADX INFO: compiled from: WidgetNoticeDialog.kt */
    public static final class Companion {
        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ void show$default(Companion companion, FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map map, StoreNotices.Dialog.Type type, Integer num, Integer num2, Integer num3, Boolean bool, String str, int i, Function0 function0, int i2, Object obj) {
            companion.show(fragmentManager, (i2 & 2) != 0 ? null : charSequence, charSequence2, charSequence3, (i2 & 16) != 0 ? null : charSequence4, (i2 & 32) != 0 ? null : map, (i2 & 64) != 0 ? null : type, (i2 & 128) != 0 ? null : num, (i2 & 256) != 0 ? null : num2, (i2 & 512) != 0 ? null : num3, (i2 & 1024) != 0 ? null : bool, (i2 & 2048) != 0 ? null : str, (i2 & 4096) != 0 ? 2 : i, (i2 & 8192) != 0 ? null : function0);
        }

        public final void show(FragmentManager fragmentManager, CharSequence headerText, CharSequence bodyText, CharSequence goText, CharSequence cancelText, Map<Integer, ? extends Function1<? super View, Unit>> listenerMap, StoreNotices.Dialog.Type type, @LayoutRes Integer aboveLayoutId, @LayoutRes Integer belowLayoutId, Integer dialogTheme, Boolean cancelable, String tag, int bodyTextAlignment, Function0<Unit> onDismiss) {
            Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            WidgetNoticeDialog widgetNoticeDialog = new WidgetNoticeDialog();
            widgetNoticeDialog.setListenerMap(listenerMap);
            widgetNoticeDialog.setOnDismiss(onDismiss);
            Bundle bundle = new Bundle();
            bundle.putCharSequence(WidgetNoticeDialog.ARG_HEADER_TEXT, headerText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_BODY_TEXT, bodyText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_OK_TEXT, goText);
            bundle.putCharSequence(WidgetNoticeDialog.ARG_CANCEL_TEXT, cancelText);
            if (type != null) {
                bundle.putString(WidgetNoticeDialog.ARG_NOTICE_TYPE, type.name());
            }
            if (aboveLayoutId != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_ABOVE_LAYOUT_ID, aboveLayoutId.intValue());
            }
            if (belowLayoutId != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_BELOW_LAYOUT_ID, belowLayoutId.intValue());
            }
            if (dialogTheme != null) {
                bundle.putInt(WidgetNoticeDialog.ARG_THEME_ID, dialogTheme.intValue());
            }
            if (cancelable != null) {
                bundle.putBoolean(WidgetNoticeDialog.ARG_CANCELABLE, cancelable.booleanValue());
            }
            bundle.putInt(WidgetNoticeDialog.ARG_BODY_TEXT_ALIGNMENT, bodyTextAlignment);
            Thread threadCurrentThread = Thread.currentThread();
            Intrinsics3.checkNotNullExpressionValue(threadCurrentThread, "Thread.currentThread()");
            StackTraceElement[] stackTrace = threadCurrentThread.getStackTrace();
            String string = stackTrace.length > 4 ? stackTrace[4].toString() : "";
            Intrinsics3.checkNotNullExpressionValue(string, "if (stacktrace.size > 4)…ace[4].toString() else \"\"");
            bundle.putString(WidgetNoticeDialog.ARG_STACK_TRACE_CALLER_FRAME, string);
            widgetNoticeDialog.setArguments(bundle);
            if (tag == null) {
                tag = WidgetNoticeDialog.class.getSimpleName();
            }
            widgetNoticeDialog.show(fragmentManager, tag);
        }

        public final void showInputModal(AppActivity activity, CharSequence headerText, CharSequence bodyText, CharSequence hintText, Function2<? super Context, ? super String, Unit> onOKClicked, Function0<Unit> onCancelClicked, Boolean cancelable, StoreNotices.InputDialog.Type type, CharSequence goText, boolean shouldHideKeyboard) {
            CharSequence charSequence;
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            Intrinsics3.checkNotNullParameter(headerText, "headerText");
            Intrinsics3.checkNotNullParameter(bodyText, "bodyText");
            Intrinsics3.checkNotNullParameter(hintText, "hintText");
            Intrinsics3.checkNotNullParameter(onOKClicked, "onOKClicked");
            Intrinsics3.checkNotNullParameter(type, "type");
            HashMap map = new HashMap();
            map.put(Integer.valueOf(R.id.notice_ok), new WidgetNoticeDialog$Companion$showInputModal$1(onOKClicked, shouldHideKeyboard));
            if (onCancelClicked != null) {
                map.put(Integer.valueOf(R.id.notice_cancel), new WidgetNoticeDialog$Companion$showInputModal$2(onCancelClicked, shouldHideKeyboard));
            }
            map.put(0, new WidgetNoticeDialog$Companion$showInputModal$3(hintText));
            boolean z2 = type == StoreNotices.InputDialog.Type.PASSWORD;
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(supportFragmentManager, "activity.supportFragmentManager");
            Integer numValueOf = Integer.valueOf(z2 ? R.layout.view_input_modal_password : R.layout.view_input_modal_text_no_suggestions);
            if (goText != null) {
                charSequence = goText;
            } else {
                String string = activity.getString(R.string.confirm);
                Intrinsics3.checkNotNullExpressionValue(string, "activity.getString(R.string.confirm)");
                charSequence = string;
            }
            show$default(this, supportFragmentManager, headerText, bodyText, charSequence, activity.getString(R.string.cancel), map, null, null, numValueOf, null, cancelable, null, 0, null, 15040, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.notice.WidgetNoticeDialog$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetNoticeDialog.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.this.dismiss();
        }
    }

    public WidgetNoticeDialog() {
        super(R.layout.widget_notice_dialog);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetNoticeDialog$binding$2.INSTANCE, null, 2, null);
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

    public static final void show(FragmentManager fragmentManager, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, CharSequence charSequence4, Map<Integer, ? extends Function1<? super View, Unit>> map, StoreNotices.Dialog.Type type, @LayoutRes Integer num, @LayoutRes Integer num2, Integer num3, Boolean bool, String str, int i, Function0<Unit> function0) {
        INSTANCE.show(fragmentManager, charSequence, charSequence2, charSequence3, charSequence4, map, type, num, num2, num3, bool, str, i, function0);
    }

    public final Map<Integer, Function1<View, Unit>> getListenerMap() {
        return this.listenerMap;
    }

    public final Function0<Unit> getOnDismiss() {
        return this.onDismiss;
    }

    public final void logOnStartError(Exception exception) {
        Intrinsics3.checkNotNullParameter(exception, "exception");
        Bundle arguments = getArguments();
        Serializable serializable = arguments != null ? arguments.getSerializable(ARG_STACK_TRACE_CALLER_FRAME) : null;
        Logger.e$default(AppLog.g, "failed to start WidgetNoticeDialog from " + serializable, exception, null, 4, null);
    }

    @Override // com.discord.app.AppDialog, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Resources.Theme theme;
        Bundle arguments = getArguments();
        if (arguments != null) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context != null && (theme = context.getTheme()) != null) {
                theme.resolveAttribute(arguments.getInt(ARG_THEME_ID, R.attr.dialogTheme), typedValue, true);
            }
            setStyle(1, typedValue.resourceId);
        }
        return super.onCreateDialog(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialog) {
        Intrinsics3.checkNotNullParameter(dialog, "dialog");
        Function0<Unit> function0 = this.onDismiss;
        if (function0 != null) {
            function0.invoke();
        }
        super.onDismiss(dialog);
    }

    @Override // com.discord.app.AppDialog
    public void onViewBound(final View view) {
        Map<Integer, ? extends Function1<? super View, Unit>> map;
        Function1<? super View, Unit> function1;
        String string;
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        Bundle arguments = getArguments();
        setCancelable(arguments != null ? arguments.getBoolean(ARG_CANCELABLE, true) : true);
        Bundle arguments2 = getArguments();
        if (arguments2 != null && (string = arguments2.getString(ARG_NOTICE_TYPE)) != null) {
            StoreNotices notices = StoreStream.INSTANCE.getNotices();
            Intrinsics3.checkNotNullExpressionValue(string, "it");
            notices.markDialogSeen(string);
        }
        Bundle arguments3 = getArguments();
        CharSequence charSequence = arguments3 != null ? arguments3.getCharSequence(ARG_HEADER_TEXT) : null;
        TextView textView = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.noticeHeader");
        textView.setText(charSequence);
        LinearLayout linearLayout = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.noticeHeaderContainer");
        linearLayout.setVisibility((charSequence == null || StringsJVM.isBlank(charSequence)) ^ true ? 0 : 8);
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.noticeBodyText");
        Bundle arguments4 = getArguments();
        linkifiedTextView.setText(arguments4 != null ? arguments4.getCharSequence(ARG_BODY_TEXT) : null);
        if (isCancelable()) {
            LinkifiedTextView linkifiedTextView2 = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(linkifiedTextView2, "binding.noticeBodyText");
            linkifiedTextView2.setMovementMethod(new ActionLinkMovementMethod(new AnonymousClass2()));
        }
        LinkifiedTextView linkifiedTextView3 = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView3, "binding.noticeBodyText");
        Bundle arguments5 = getArguments();
        linkifiedTextView3.setTextAlignment(arguments5 != null ? arguments5.getInt(ARG_BODY_TEXT_ALIGNMENT) : 2);
        MaterialButton materialButton = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.noticeOk");
        Bundle arguments6 = getArguments();
        ViewExtensions.setTextAndVisibilityBy(materialButton, arguments6 != null ? arguments6.getCharSequence(ARG_OK_TEXT) : null);
        Bundle arguments7 = getArguments();
        CharSequence charSequence2 = arguments7 != null ? arguments7.getCharSequence(ARG_CANCEL_TEXT) : null;
        MaterialButton materialButton2 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.noticeCancel");
        ViewExtensions.setTextAndVisibilityBy(materialButton2, charSequence2);
        Bundle arguments8 = getArguments();
        if (arguments8 != null) {
            insertLayoutInBundle(arguments8, ARG_ABOVE_LAYOUT_ID, 0);
        }
        Bundle arguments9 = getArguments();
        if (arguments9 != null) {
            LinearLayout linearLayout2 = getBinding().f2500b;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.noticeBodyContainer");
            insertLayoutInBundle(arguments9, ARG_BELOW_LAYOUT_ID, linearLayout2.getChildCount());
        }
        getBinding().g.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeDialog.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeDialog.this.dismiss();
            }
        });
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeDialog.onViewBound.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetNoticeDialog.this.dismiss();
            }
        });
        Map<Integer, ? extends Function1<? super View, Unit>> map2 = this.listenerMap;
        if (map2 != null) {
            for (final Map.Entry<Integer, ? extends Function1<? super View, Unit>> entry : map2.entrySet()) {
                View viewFindViewById = view.findViewById(entry.getKey().intValue());
                if (viewFindViewById != null) {
                    viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.notice.WidgetNoticeDialog$onViewBound$$inlined$forEach$lambda$1
                        @Override // android.view.View.OnClickListener
                        public final void onClick(View view2) {
                            ((Function1) entry.getValue()).invoke(view);
                            this.dismiss();
                        }
                    });
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
