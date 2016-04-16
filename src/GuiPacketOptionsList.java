public class GuiPacketOptionsList extends bdi
{
    private final GuiServerPackets guiServerPackets;
    private final bcc mc;
    private final bdi.a listEntries[];
    private int maxListLabelWidth = 0;
    public static int lastBtnIndex;
    
    public boolean isActive[];

    public GuiPacketOptionsList(GuiServerPackets guiServerPackets, bcc mcIn)
    {
        super(mcIn, guiServerPackets.l, guiServerPackets.m, 63, guiServerPackets.m - 32, 20);
        this.guiServerPackets = guiServerPackets;
        this.mc = mcIn;
        this.listEntries = new bdi.a[ServerPacketData.isActive.length];
        
        isActive = new boolean[this.listEntries.length];
        isActive = ServerPacketData.isActive.clone();
        
        for(int packetID = 0; packetID < this.listEntries.length; packetID++)
        {
            this.listEntries[packetID] = new PacketOptionEntry(packetID);
        }
    }
    
    // getSize()
    @Override
    protected int b()
    {
        return this.listEntries.length;
    }

    // getListEntry()
    @Override
    public bdi.a b(int idx)
    {
        if(idx < 0 || idx >= this.b()) {
            System.err.println("[Cubitick]: index out of bounds in GuiPacketOptionsList.getListEntry()");
            return null;
        }
        return this.listEntries[idx];
    }
    
    // getScrollBarX()
    @Override
    protected int d()
    {
        return super.d() + 15;
    }

    // getListWidth()
    @Override
    public int c()
    {
        return super.c() + 32;
    }
    
    public void setAll(boolean state)
    {
        for(int i = 0; i < listEntries.length; i++)
        {
            isActive[i] = state;
        }
    }
    
    

    public class PacketOptionEntry implements bdi.a
    {
        public final String baseLabel;
        public final bcw btn;
        public final int packetID;

        private PacketOptionEntry(int packetID)
        {
            this.packetID = packetID;
            this.baseLabel = ServerPacketData.packetName[packetID];
            this.btn = new bcw(0, 0, 0, 250, 18, this.baseLabel);
        }

        // drawEntry(..)
        public void a(int slotIndex, int x, int y, int listWidth, int slotHeight, int mouseX, int mouseY, boolean isSelected)
        {
            if(this.baseLabel == null)
            {
                this.btn.j = "";
                this.btn.l = false;
            }
            else
            {
                this.btn.j = this.baseLabel + ": " + (isActive[this.packetID] ? "§aactive":"§cinactive");
                this.btn.l = guiServerPackets.enabled;
            }

            this.btn.h = x;
            this.btn.i = y;
            
            this.btn.a(GuiPacketOptionsList.this.mc, mouseX, mouseY);
        }

        // mousePressed(..)
        public boolean a(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY)
        {
            if(this.btn.l && this.btn.c(GuiPacketOptionsList.this.mc, x, y))
            {
                if(GuiPacketOptionsList.lastBtnIndex != slotIndex)
                {
                    GuiPacketOptionsList.lastBtnIndex = slotIndex;
                    isActive[slotIndex] = !isActive[slotIndex];
                }
                else {
                    GuiPacketOptionsList.lastBtnIndex = -1;
                    return false;
                }
                //GuiPacketOptionsList.this.guiServerPackets.buttonId = this.packetID;
                
                return true;
            }
            else
            {
                return false;
            }
        }
        
        // mouseReleased(..)
        public void b(int slotIndex, int x, int y, int mouseEvent, int relativeX, int relativeY)
        {
            this.btn.a(x, y);
            System.out.println("Release- Slot: " + slotIndex + ", Event: " + mouseEvent);
        }
        
        // setSelected
        @Override
        public void a(int arg0, int arg1, int arg2) {
            // TODO Auto-generated method stub
        }
    }
}