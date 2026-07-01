package androidx.constraintlayout.widget;

import android.view.ViewGroup$MarginLayoutParams;
import b.d.b.a.a;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class ConstraintSet$Constraint {
    public int mViewId;
    public final ConstraintSet$PropertySet propertySet = new ConstraintSet$PropertySet();
    public final ConstraintSet$Motion motion = new ConstraintSet$Motion();
    public final ConstraintSet$Layout layout = new ConstraintSet$Layout();
    public final ConstraintSet$Transform transform = new ConstraintSet$Transform();
    public HashMap<String, ConstraintAttribute> mCustomConstraints = new HashMap<>();

    public static /* synthetic */ void access$000(ConstraintSet$Constraint constraintSet$Constraint, int i, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        constraintSet$Constraint.fillFrom(i, constraintLayout$LayoutParams);
    }

    public static /* synthetic */ void access$300(ConstraintSet$Constraint constraintSet$Constraint, ConstraintHelper constraintHelper, int i, Constraints$LayoutParams constraints$LayoutParams) {
        constraintSet$Constraint.fillFromConstraints(constraintHelper, i, constraints$LayoutParams);
    }

    public static /* synthetic */ void access$400(ConstraintSet$Constraint constraintSet$Constraint, int i, Constraints$LayoutParams constraints$LayoutParams) {
        constraintSet$Constraint.fillFromConstraints(i, constraints$LayoutParams);
    }

    public static /* synthetic */ void access$500(ConstraintSet$Constraint constraintSet$Constraint, String str, int i) {
        constraintSet$Constraint.setIntValue(str, i);
    }

    public static /* synthetic */ void access$600(ConstraintSet$Constraint constraintSet$Constraint, String str, int i) {
        constraintSet$Constraint.setColorValue(str, i);
    }

    public static /* synthetic */ void access$700(ConstraintSet$Constraint constraintSet$Constraint, String str, float f) {
        constraintSet$Constraint.setFloatValue(str, f);
    }

    public static /* synthetic */ void access$800(ConstraintSet$Constraint constraintSet$Constraint, String str, String str2) {
        constraintSet$Constraint.setStringValue(str, str2);
    }

    private void fillFrom(int i, ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        this.mViewId = i;
        ConstraintSet$Layout constraintSet$Layout = this.layout;
        constraintSet$Layout.leftToLeft = constraintLayout$LayoutParams.leftToLeft;
        constraintSet$Layout.leftToRight = constraintLayout$LayoutParams.leftToRight;
        constraintSet$Layout.rightToLeft = constraintLayout$LayoutParams.rightToLeft;
        constraintSet$Layout.rightToRight = constraintLayout$LayoutParams.rightToRight;
        constraintSet$Layout.topToTop = constraintLayout$LayoutParams.topToTop;
        constraintSet$Layout.topToBottom = constraintLayout$LayoutParams.topToBottom;
        constraintSet$Layout.bottomToTop = constraintLayout$LayoutParams.bottomToTop;
        constraintSet$Layout.bottomToBottom = constraintLayout$LayoutParams.bottomToBottom;
        constraintSet$Layout.baselineToBaseline = constraintLayout$LayoutParams.baselineToBaseline;
        constraintSet$Layout.startToEnd = constraintLayout$LayoutParams.startToEnd;
        constraintSet$Layout.startToStart = constraintLayout$LayoutParams.startToStart;
        constraintSet$Layout.endToStart = constraintLayout$LayoutParams.endToStart;
        constraintSet$Layout.endToEnd = constraintLayout$LayoutParams.endToEnd;
        constraintSet$Layout.horizontalBias = constraintLayout$LayoutParams.horizontalBias;
        constraintSet$Layout.verticalBias = constraintLayout$LayoutParams.verticalBias;
        constraintSet$Layout.dimensionRatio = constraintLayout$LayoutParams.dimensionRatio;
        constraintSet$Layout.circleConstraint = constraintLayout$LayoutParams.circleConstraint;
        constraintSet$Layout.circleRadius = constraintLayout$LayoutParams.circleRadius;
        constraintSet$Layout.circleAngle = constraintLayout$LayoutParams.circleAngle;
        constraintSet$Layout.editorAbsoluteX = constraintLayout$LayoutParams.editorAbsoluteX;
        constraintSet$Layout.editorAbsoluteY = constraintLayout$LayoutParams.editorAbsoluteY;
        constraintSet$Layout.orientation = constraintLayout$LayoutParams.orientation;
        constraintSet$Layout.guidePercent = constraintLayout$LayoutParams.guidePercent;
        constraintSet$Layout.guideBegin = constraintLayout$LayoutParams.guideBegin;
        constraintSet$Layout.guideEnd = constraintLayout$LayoutParams.guideEnd;
        ConstraintSet$Layout constraintSet$Layout2 = this.layout;
        constraintSet$Layout2.mWidth = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).width;
        constraintSet$Layout2.mHeight = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).height;
        constraintSet$Layout2.leftMargin = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).leftMargin;
        constraintSet$Layout2.rightMargin = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).rightMargin;
        constraintSet$Layout2.topMargin = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).topMargin;
        constraintSet$Layout2.bottomMargin = ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).bottomMargin;
        constraintSet$Layout2.verticalWeight = constraintLayout$LayoutParams.verticalWeight;
        constraintSet$Layout2.horizontalWeight = constraintLayout$LayoutParams.horizontalWeight;
        constraintSet$Layout2.verticalChainStyle = constraintLayout$LayoutParams.verticalChainStyle;
        constraintSet$Layout2.horizontalChainStyle = constraintLayout$LayoutParams.horizontalChainStyle;
        constraintSet$Layout2.constrainedWidth = constraintLayout$LayoutParams.constrainedWidth;
        constraintSet$Layout2.constrainedHeight = constraintLayout$LayoutParams.constrainedHeight;
        constraintSet$Layout2.widthDefault = constraintLayout$LayoutParams.matchConstraintDefaultWidth;
        constraintSet$Layout2.heightDefault = constraintLayout$LayoutParams.matchConstraintDefaultHeight;
        constraintSet$Layout2.widthMax = constraintLayout$LayoutParams.matchConstraintMaxWidth;
        constraintSet$Layout2.heightMax = constraintLayout$LayoutParams.matchConstraintMaxHeight;
        constraintSet$Layout2.widthMin = constraintLayout$LayoutParams.matchConstraintMinWidth;
        constraintSet$Layout2.heightMin = constraintLayout$LayoutParams.matchConstraintMinHeight;
        constraintSet$Layout2.widthPercent = constraintLayout$LayoutParams.matchConstraintPercentWidth;
        constraintSet$Layout2.heightPercent = constraintLayout$LayoutParams.matchConstraintPercentHeight;
        constraintSet$Layout2.mConstraintTag = constraintLayout$LayoutParams.constraintTag;
        constraintSet$Layout2.goneTopMargin = constraintLayout$LayoutParams.goneTopMargin;
        constraintSet$Layout2.goneBottomMargin = constraintLayout$LayoutParams.goneBottomMargin;
        constraintSet$Layout2.goneLeftMargin = constraintLayout$LayoutParams.goneLeftMargin;
        constraintSet$Layout2.goneRightMargin = constraintLayout$LayoutParams.goneRightMargin;
        ConstraintSet$Layout constraintSet$Layout3 = this.layout;
        constraintSet$Layout3.goneStartMargin = constraintLayout$LayoutParams.goneStartMargin;
        constraintSet$Layout3.goneEndMargin = constraintLayout$LayoutParams.goneEndMargin;
        constraintSet$Layout3.endMargin = constraintLayout$LayoutParams.getMarginEnd();
        this.layout.startMargin = constraintLayout$LayoutParams.getMarginStart();
    }

    private void fillFromConstraints(ConstraintHelper constraintHelper, int i, Constraints$LayoutParams constraints$LayoutParams) {
        fillFromConstraints(i, constraints$LayoutParams);
        if (constraintHelper instanceof Barrier) {
            ConstraintSet$Layout constraintSet$Layout = this.layout;
            constraintSet$Layout.mHelperType = 1;
            Barrier barrier = (Barrier) constraintHelper;
            constraintSet$Layout.mBarrierDirection = barrier.getType();
            this.layout.mReferenceIds = barrier.getReferencedIds();
            this.layout.mBarrierMargin = barrier.getMargin();
        }
    }

    private ConstraintAttribute get(String str, ConstraintAttribute$AttributeType constraintAttribute$AttributeType) {
        if (!this.mCustomConstraints.containsKey(str)) {
            ConstraintAttribute constraintAttribute = new ConstraintAttribute(str, constraintAttribute$AttributeType);
            this.mCustomConstraints.put(str, constraintAttribute);
            return constraintAttribute;
        }
        ConstraintAttribute constraintAttribute2 = this.mCustomConstraints.get(str);
        if (constraintAttribute2.getType() == constraintAttribute$AttributeType) {
            return constraintAttribute2;
        }
        StringBuilder sbU = a.U("ConstraintAttribute is already a ");
        sbU.append(constraintAttribute2.getType().name());
        throw new IllegalArgumentException(sbU.toString());
    }

    private void setColorValue(String str, int i) {
        get(str, ConstraintAttribute$AttributeType.COLOR_TYPE).setColorValue(i);
    }

    private void setFloatValue(String str, float f) {
        get(str, ConstraintAttribute$AttributeType.FLOAT_TYPE).setFloatValue(f);
    }

    private void setIntValue(String str, int i) {
        get(str, ConstraintAttribute$AttributeType.INT_TYPE).setIntValue(i);
    }

    private void setStringValue(String str, String str2) {
        get(str, ConstraintAttribute$AttributeType.STRING_TYPE).setStringValue(str2);
    }

    public void applyTo(ConstraintLayout$LayoutParams constraintLayout$LayoutParams) {
        ConstraintSet$Layout constraintSet$Layout = this.layout;
        constraintLayout$LayoutParams.leftToLeft = constraintSet$Layout.leftToLeft;
        constraintLayout$LayoutParams.leftToRight = constraintSet$Layout.leftToRight;
        constraintLayout$LayoutParams.rightToLeft = constraintSet$Layout.rightToLeft;
        constraintLayout$LayoutParams.rightToRight = constraintSet$Layout.rightToRight;
        constraintLayout$LayoutParams.topToTop = constraintSet$Layout.topToTop;
        constraintLayout$LayoutParams.topToBottom = constraintSet$Layout.topToBottom;
        constraintLayout$LayoutParams.bottomToTop = constraintSet$Layout.bottomToTop;
        constraintLayout$LayoutParams.bottomToBottom = constraintSet$Layout.bottomToBottom;
        constraintLayout$LayoutParams.baselineToBaseline = constraintSet$Layout.baselineToBaseline;
        constraintLayout$LayoutParams.startToEnd = constraintSet$Layout.startToEnd;
        constraintLayout$LayoutParams.startToStart = constraintSet$Layout.startToStart;
        constraintLayout$LayoutParams.endToStart = constraintSet$Layout.endToStart;
        constraintLayout$LayoutParams.endToEnd = constraintSet$Layout.endToEnd;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).leftMargin = constraintSet$Layout.leftMargin;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).rightMargin = constraintSet$Layout.rightMargin;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).topMargin = constraintSet$Layout.topMargin;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).bottomMargin = constraintSet$Layout.bottomMargin;
        constraintLayout$LayoutParams.goneStartMargin = constraintSet$Layout.goneStartMargin;
        constraintLayout$LayoutParams.goneEndMargin = constraintSet$Layout.goneEndMargin;
        constraintLayout$LayoutParams.goneTopMargin = constraintSet$Layout.goneTopMargin;
        constraintLayout$LayoutParams.goneBottomMargin = constraintSet$Layout.goneBottomMargin;
        constraintLayout$LayoutParams.horizontalBias = constraintSet$Layout.horizontalBias;
        constraintLayout$LayoutParams.verticalBias = constraintSet$Layout.verticalBias;
        constraintLayout$LayoutParams.circleConstraint = constraintSet$Layout.circleConstraint;
        constraintLayout$LayoutParams.circleRadius = constraintSet$Layout.circleRadius;
        ConstraintSet$Layout constraintSet$Layout2 = this.layout;
        constraintLayout$LayoutParams.circleAngle = constraintSet$Layout2.circleAngle;
        constraintLayout$LayoutParams.dimensionRatio = constraintSet$Layout2.dimensionRatio;
        constraintLayout$LayoutParams.editorAbsoluteX = constraintSet$Layout2.editorAbsoluteX;
        constraintLayout$LayoutParams.editorAbsoluteY = constraintSet$Layout2.editorAbsoluteY;
        constraintLayout$LayoutParams.verticalWeight = constraintSet$Layout2.verticalWeight;
        constraintLayout$LayoutParams.horizontalWeight = constraintSet$Layout2.horizontalWeight;
        constraintLayout$LayoutParams.verticalChainStyle = constraintSet$Layout2.verticalChainStyle;
        constraintLayout$LayoutParams.horizontalChainStyle = constraintSet$Layout2.horizontalChainStyle;
        constraintLayout$LayoutParams.constrainedWidth = constraintSet$Layout2.constrainedWidth;
        constraintLayout$LayoutParams.constrainedHeight = constraintSet$Layout2.constrainedHeight;
        constraintLayout$LayoutParams.matchConstraintDefaultWidth = constraintSet$Layout2.widthDefault;
        constraintLayout$LayoutParams.matchConstraintDefaultHeight = constraintSet$Layout2.heightDefault;
        constraintLayout$LayoutParams.matchConstraintMaxWidth = constraintSet$Layout2.widthMax;
        constraintLayout$LayoutParams.matchConstraintMaxHeight = constraintSet$Layout2.heightMax;
        constraintLayout$LayoutParams.matchConstraintMinWidth = constraintSet$Layout2.widthMin;
        constraintLayout$LayoutParams.matchConstraintMinHeight = constraintSet$Layout2.heightMin;
        constraintLayout$LayoutParams.matchConstraintPercentWidth = constraintSet$Layout2.widthPercent;
        constraintLayout$LayoutParams.matchConstraintPercentHeight = constraintSet$Layout2.heightPercent;
        constraintLayout$LayoutParams.orientation = constraintSet$Layout2.orientation;
        constraintLayout$LayoutParams.guidePercent = constraintSet$Layout2.guidePercent;
        constraintLayout$LayoutParams.guideBegin = constraintSet$Layout2.guideBegin;
        constraintLayout$LayoutParams.guideEnd = constraintSet$Layout2.guideEnd;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).width = constraintSet$Layout2.mWidth;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).height = constraintSet$Layout2.mHeight;
        String str = constraintSet$Layout2.mConstraintTag;
        if (str != null) {
            constraintLayout$LayoutParams.constraintTag = str;
        }
        constraintLayout$LayoutParams.setMarginStart(this.layout.startMargin);
        constraintLayout$LayoutParams.setMarginEnd(this.layout.endMargin);
        constraintLayout$LayoutParams.validate();
    }

    /* JADX INFO: renamed from: clone, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ Object m2clone() throws CloneNotSupportedException {
        return clone();
    }

    public ConstraintSet$Constraint clone() {
        ConstraintSet$Constraint constraintSet$Constraint = new ConstraintSet$Constraint();
        constraintSet$Constraint.layout.copyFrom(this.layout);
        constraintSet$Constraint.motion.copyFrom(this.motion);
        constraintSet$Constraint.propertySet.copyFrom(this.propertySet);
        constraintSet$Constraint.transform.copyFrom(this.transform);
        constraintSet$Constraint.mViewId = this.mViewId;
        return constraintSet$Constraint;
    }

    private void fillFromConstraints(int i, Constraints$LayoutParams constraints$LayoutParams) {
        fillFrom(i, constraints$LayoutParams);
        this.propertySet.alpha = constraints$LayoutParams.alpha;
        ConstraintSet$Transform constraintSet$Transform = this.transform;
        constraintSet$Transform.rotation = constraints$LayoutParams.rotation;
        constraintSet$Transform.rotationX = constraints$LayoutParams.rotationX;
        constraintSet$Transform.rotationY = constraints$LayoutParams.rotationY;
        constraintSet$Transform.scaleX = constraints$LayoutParams.scaleX;
        constraintSet$Transform.scaleY = constraints$LayoutParams.scaleY;
        constraintSet$Transform.transformPivotX = constraints$LayoutParams.transformPivotX;
        constraintSet$Transform.transformPivotY = constraints$LayoutParams.transformPivotY;
        constraintSet$Transform.translationX = constraints$LayoutParams.translationX;
        constraintSet$Transform.translationY = constraints$LayoutParams.translationY;
        constraintSet$Transform.translationZ = constraints$LayoutParams.translationZ;
        constraintSet$Transform.elevation = constraints$LayoutParams.elevation;
        constraintSet$Transform.applyElevation = constraints$LayoutParams.applyElevation;
    }
}
