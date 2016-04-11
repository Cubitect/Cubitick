package cubimod.gui;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;

import cubimod.settings.ServerPacketData;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiKeyBindingList;
import net.minecraft.client.gui.GuiListExtended;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptionSlider;
import net.minecraft.client.gui.GuiOptionsRowList;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public class GuiServerPackets extends GuiScreen
{
    private GuiScreen parentScreen;
    private GameSettings options;
    protected String screenTitle = "Server Packet Analysis...";
    
    private GuiPacketOptionsList optionsList;
    private GuiButton buttonDone, bEnable, bActivateAll, bDeactivateAll;
    public boolean enabled;
    

    public GuiServerPackets(GuiScreen screen, GameSettings settings)
    {
        this.parentScreen = screen;
        this.options = settings;
    }

    public void initGui()
    {
        this.enabled = ServerPacketData.enabled;
        
        optionsList = new GuiPacketOptionsList(this, this.mc);
        
        buttonList.add(new GuiButton(200, width / 2 - 155 + 160, height - 29, 150, 20, I18n.format("gui.done", new Object[0])));
        buttonList.add(bEnable = new GuiButton(201, width / 2 - 155, height - 29, 150, 20, this.enabled ? "Packet Analysis: Enabled" : "Packet Analysis: Disabled"));
        buttonList.add(bActivateAll = new GuiButton(202, width / 2 - 155, 20, 150, 20, "Activate All"));
        buttonList.add(bDeactivateAll = new GuiButton(203, width / 2 - 155 + 160, 20, 150, 20, "Deactivate All"));
        
        bActivateAll.enabled = this.enabled;
        bDeactivateAll.enabled = this.enabled;
    }

    public void handleMouseInput() throws IOException
    {
        super.handleMouseInput();
        this.optionsList.func_178039_p();
    }
    
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton); // checks menu action buttons
        this.optionsList.func_148179_a(mouseX, mouseY, mouseButton);
    }
    
    protected void mouseReleased(int mouseX, int mouseY, int state)
    {
        if(state != 0 || !this.optionsList.func_148181_b(mouseX, mouseY, state))
        {
            super.mouseReleased(mouseX, mouseY, state);
        }
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button.id == 200) // Done
        {
            ServerPacketData.enabled = this.enabled;
            ServerPacketData.isActive = this.optionsList.isActive;
            ServerPacketData.saveSettings();
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else if(button.id == 201) // Enable
        {
            this.enabled = !this.enabled;
            bActivateAll.enabled = this.enabled;
            bDeactivateAll.enabled = this.enabled;
            this.bEnable.displayString = this.enabled ? "Packet Analysis: Enabled" : "Packet Analysis: Disabled";
        }
        else if(button.id == 202) // Activate All
        {
            optionsList.setAll(true);
        }
        else if(button.id == 203) // Deactivate All
        {
            optionsList.setAll(false);
        }
        else
        {
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.optionsList.drawScreen(mouseX, mouseY, partialTicks);
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 8, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}