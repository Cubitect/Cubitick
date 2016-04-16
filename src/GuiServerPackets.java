public class GuiServerPackets extends bey
{
    private bey parentScreen;
    private bce options;
    protected String screenTitle = "Server Packet Analysis...";
    
    private GuiPacketOptionsList optionsList;
    private bcw buttonDone, bEnable, bActivateAll, bDeactivateAll;
    public boolean enabled;
    

    public GuiServerPackets(bey screen, bce settings)
    {
        this.parentScreen = screen;
        this.options = settings;
    }

    // initGui()
    @Override
    public void b()
    {
        this.enabled = ServerPacketData.enabled;
        
        optionsList = new GuiPacketOptionsList(this, this.j);
        
        // l = width, m = height, bwl.a() = I18n.format()
        n.add(new bcw(200, l / 2 - 155 + 160, m - 29, 150, 20, bwl.a("gui.done", new Object[0])));
        n.add(bEnable = new bcw(201, l / 2 - 155, m - 29, 150, 20, this.enabled ? "Packet Analysis: Enabled" : "Packet Analysis: Disabled"));
        n.add(bActivateAll = new bcw(202, l / 2 - 155, 20, 150, 20, "Activate All"));
        n.add(bDeactivateAll = new bcw(203, l / 2 - 155 + 160, 20, 150, 20, "Deactivate All"));
        
        bActivateAll.l = this.enabled;
        bDeactivateAll.l = this.enabled;
    }

    // handleMouseInput
    @Override
    public void k()
    {
        super.k();
        this.optionsList.p();
    }
    
    // mouseClicked
    @Override
    protected void a(int mouseX, int mouseY, int mouseButton)
    {
        super.a(mouseX, mouseY, mouseButton); // checks menu action buttons
        this.optionsList.b(mouseX, mouseY, mouseButton);
    }
    
    // mouseReleased
    @Override
    protected void b(int mouseX, int mouseY, int state)
    {
        if(state != 0 || !this.optionsList.b(mouseX, mouseY, state))
        {
            super.b(mouseX, mouseY, state);
        }
    }

    // actionPerformed
    @Override
    protected void a(bcw button)
    {
        if(button.k == 200) // Done
        {
            ServerPacketData.enabled = this.enabled;
            ServerPacketData.isActive = this.optionsList.isActive;
            ServerPacketData.saveSettings();
            this.j.a(this.parentScreen);
        }
        else if(button.k == 201) // Enable
        {
            this.enabled = !this.enabled;
            bActivateAll.l = this.enabled;
            bDeactivateAll.l = this.enabled;
            this.bEnable.j = this.enabled ? "Packet Analysis: Enabled" : "Packet Analysis: Disabled";
        }
        else if(button.k == 202) // Activate All
        {
            optionsList.setAll(true);
        }
        else if(button.k == 203) // Deactivate All
        {
            optionsList.setAll(false);
        }
        else
        {
        }
        
        GuiPacketOptionsList.lastBtnIndex = -1;
    }

    // drawScreen
    @Override
    public void a(int mouseX, int mouseY, float partialTicks)
    {
        this.c(); // drawDefaultBackground
        this.optionsList.a(mouseX, mouseY, partialTicks);
        // drawString(fontRendererObj .. )
        this.a(this.q, this.screenTitle, this.l / 2, 8, 16777215);
        super.a(mouseX, mouseY, partialTicks);
    }
}