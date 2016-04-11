package cubimod.gui;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.google.common.collect.Lists;

import cubimod.settings.ServerPacketData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiControls;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptionsRowList;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.EnumChatFormatting;

public class GuiPacketOptionsList extends GuiListExtended
{
    private final GuiServerPackets guiServerPackets;
    private final Minecraft mc;
    private final GuiListExtended.IGuiListEntry listEntries[];
    private int maxListLabelWidth = 0;
    
    public boolean isActive[];

    public GuiPacketOptionsList(GuiServerPackets guiServerPackets, Minecraft mcIn)
    {
        super(mcIn, guiServerPackets.width, guiServerPackets.height, 63, guiServerPackets.height - 32, 20);
        this.guiServerPackets = guiServerPackets;
        this.mc = mcIn;
        this.listEntries = new GuiListExtended.IGuiListEntry[ServerPacketData.isActive.length];
        
        isActive = new boolean[this.listEntries.length];
        isActive = ServerPacketData.isActive.clone();
        
        for(int packetID = 0; packetID < this.listEntries.length; packetID++)
        {
            this.listEntries[packetID] = new PacketOptionEntry(packetID);
        }
    }

    protected int getSize()
    {
        return this.listEntries.length;
    }

    public GuiListExtended.IGuiListEntry getListEntry(int idx)
    {
        return this.listEntries[idx];
    }

    protected int getScrollBarX()
    {
        return super.getScrollBarX() + 15;
    }

    public int getListWidth()
    {
        return super.getListWidth() + 32;
    }
    
    public void setAll(boolean state)
    {
        for(int i = 0; i < listEntries.length; i++)
        {
            isActive[i] = state;
        }
    }

    public class PacketOptionEntry implements GuiListExtended.IGuiListEntry
    {
        public final String baseLabel;
        public final GuiButton btn;
        public final int packetID;

        private PacketOptionEntry(int packetID)
        {
            this.packetID = packetID;
            this.baseLabel = ServerPacketData.packetName[packetID];
            this.btn = new GuiButton(0, 0, 0, 250, 18, this.baseLabel);
        }

        public void drawEntry(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected)
        {
            if(this.baseLabel == null)
            {
                this.btn.displayString = "";
                this.btn.enabled = false;
            }
            else
            {
                this.btn.displayString = this.baseLabel + ": " + (isActive[this.packetID] ? "§aactive":"§cinactive");
                this.btn.enabled = guiServerPackets.enabled;
            }

            this.btn.xPosition = x;
            this.btn.yPosition = y;
            
            this.btn.drawButton(GuiPacketOptionsList.this.mc, mouseX, mouseY);
        }

        public boolean mousePressed(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY)
        {
            if(this.btn.enabled && this.btn.mousePressed(GuiPacketOptionsList.this.mc, x, y))
            {
                //GuiPacketOptionsList.this.guiServerPackets.buttonId = this.packetID;
                isActive[this.packetID] = !isActive[this.packetID];
                return true;
            }
            else
            {
                return false;
            }
        }

        public void mouseReleased(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY)
        {
            this.btn.mouseReleased(x, y);
        }

        public void setSelected(int p_178011_1_, int p_178011_2_, int p_178011_3_) {}
    }
}
    
    