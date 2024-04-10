package robots.view;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class GameWindowDiffblueTest {
    /**
     * Method under test: {@link GameWindow#onUiChanged()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testOnUiChanged() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        GameWindow gameWindow = null;

        // Act
        gameWindow.onUiChanged();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: {@link GameWindow#closeWindow()}
     */
    @Test
    void testCloseWindow() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   Add getters for the following fields or make them package-private:
        //     GameWindow.m_visualizer
        //     JInternalFrame.closable
        //     JInternalFrame.danger
        //     JInternalFrame.defaultCloseOperation
        //     JInternalFrame.desktopIcon
        //     JInternalFrame.frameIcon
        //     JInternalFrame.iconable
        //     JInternalFrame.isClosed
        //     JInternalFrame.isDragging
        //     JInternalFrame.isIcon
        //     JInternalFrame.isMaximum
        //     JInternalFrame.isSelected
        //     JInternalFrame.lastCursor
        //     JInternalFrame.lastFocusOwner
        //     JInternalFrame.maximizable
        //     JInternalFrame.normalBounds
        //     JInternalFrame.opened
        //     JInternalFrame.resizable
        //     JInternalFrame.rootPane
        //     JInternalFrame.rootPaneCheckingEnabled
        //     JInternalFrame.title
        //     JComponent.DEBUG_GRAPHICS_LOADED
        //     JComponent.aaHint
        //     JComponent.actionMap
        //     JComponent.alignmentX
        //     JComponent.alignmentY
        //     JComponent.ancestorInputMap
        //     JComponent.autoscrolls
        //     JComponent.border
        //     JComponent.clientProperties
        //     JComponent.componentObtainingGraphicsFrom
        //     JComponent.componentObtainingGraphicsFromLock
        //     JComponent.flags
        //     JComponent.focusInputMap
        //     JComponent.inputVerifier
        //     JComponent.isAlignmentXSet
        //     JComponent.isAlignmentYSet
        //     JComponent.lcdRenderingHint
        //     JComponent.listenerList
        //     JComponent.managingFocusBackwardTraversalKeys
        //     JComponent.managingFocusForwardTraversalKeys
        //     JComponent.paintingChild
        //     JComponent.popupMenu
        //     JComponent.revalidateRunnableScheduled
        //     JComponent.tempRectangles
        //     JComponent.ui
        //     JComponent.verifyInputWhenFocusTarget
        //     JComponent.vetoableChangeSupport
        //     JComponent.windowInputMap
        //     Container.component
        //     Container.containerListener
        //     Container.containerSerializedDataVersion
        //     Container.descendUnconditionallyWhenValidating
        //     Container.descendantsCount
        //     Container.dispatcher
        //     Container.focusCycleRoot
        //     Container.focusTraversalPolicy
        //     Container.focusTraversalPolicyProvider
        //     Container.layoutMgr
        //     Container.listeningBoundsChildren
        //     Container.listeningChildren
        //     Container.modalAppContext
        //     Container.modalComp
        //     Container.numOfHWComponents
        //     Container.numOfLWComponents
        //     Container.preserveBackgroundColor
        //     Container.printing
        //     Container.printingThreads
        //     Component.acc
        //     Component.accessibleContext
        //     Component.appContext
        //     Component.autoFocusTransferOnDisposal
        //     Component.background
        //     Component.backgroundEraseDisabled
        //     Component.boundsOp
        //     Component.bufferStrategy
        //     Component.changeSupport
        //     Component.coalescingEnabled
        //     Component.componentListener
        //     Component.componentOrientation
        //     Component.componentSerializedDataVersion
        //     Component.compoundShape
        //     Component.cursor
        //     Component.dropTarget
        //     Component.enabled
        //     Component.eventCache
        //     Component.eventMask
        //     Component.focusListener
        //     Component.focusTraversalKeys
        //     Component.focusTraversalKeysEnabled
        //     Component.focusable
        //     Component.font
        //     Component.foreground
        //     Component.graphicsConfig
        //     Component.height
        //     Component.hierarchyBoundsListener
        //     Component.hierarchyListener
        //     Component.ignoreRepaint
        //     Component.incRate
        //     Component.inputMethodListener
        //     Component.isAddNotifyComplete
        //     Component.isFocusTraversableOverridden
        //     Component.isInc
        //     Component.isPacked
        //     Component.keyListener
        //     Component.locale
        //     Component.maxSize
        //     Component.maxSizeSet
        //     Component.minSize
        //     Component.minSizeSet
        //     Component.mixingCutoutRegion
        //     Component.mouseListener
        //     Component.mouseMotionListener
        //     Component.mouseWheelListener
        //     Component.name
        //     Component.nameExplicitlySet
        //     Component.newEventsOnly
        //     Component.objectLock
        //     Component.parent
        //     Component.peer
        //     Component.peerFont
        //     Component.popups
        //     Component.prefSize
        //     Component.prefSizeSet
        //     Component.requestFocusController
        //     Component.valid
        //     Component.visible
        //     Component.width
        //     Component.x
        //     Component.y

        // Arrange and Act
        (new GameWindow()).closeWindow();
    }

    /**
     * Method under test: {@link GameWindow#get_visualizer()}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGet_visualizer() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        // TODO: Populate arranged inputs
        GameWindow gameWindow = null;

        // Act
        GameVisualizer actualGet_visualizerResult = gameWindow.get_visualizer();

        // Assert
        // TODO: Add assertions on result
    }

    /**
     * Method under test: default or parameterless constructor of {@link GameWindow}
     */
    @Test
    void testNewGameWindow() {
        // Arrange and Act
        GameWindow actualGameWindow = new GameWindow();

        // Assert
        Object expectedTreeLock = actualGameWindow.getTreeLock();
        assertSame(expectedTreeLock, actualGameWindow.getRootPane().getTreeLock());
    }
}
