package pl.edu.pk.it.zsbd.eshop.product.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.CustomerService;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.AddCustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.customer.dto.CustomerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.OrderService;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.AddOrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.order.dto.OrderDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.ProducerService;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.AddProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.producer.dto.ProducerDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.ProductService;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.AddProductDto;
import pl.edu.pk.it.zsbd.eshop.product.application.product.dto.ProductDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(DataLoader.class);
    private final ProductService productService;
    private final ProducerService producerService;
    private final CustomerService customerService;
    private final OrderService orderService;

    public DataLoader(ProductService productService, ProducerService producerService, CustomerService customerService, OrderService orderService) {
        this.productService = productService;
        this.producerService = producerService;
        this.customerService = customerService;
        this.orderService = orderService;
    }

    public List<OrderDto> loadOrders(int entitiesCount) {
        var products = loadProducts();
        var customers = loadCustomers();
        List<OrderDto> allOrders = new ArrayList<>();
        for (int i = 0; i < entitiesCount; i++) {
            Random random = new Random();
            int productIndex = random.nextInt(products.size() - 1);
            int customerIndex = random.nextInt(customers.size() - 1);
            int quantity = random.nextInt(10) + 1;

            var order = orderService.addOrder(
                    new AddOrderDto(customers.get(customerIndex), products.get(productIndex), quantity)
            );
            allOrders.add(order);
        }
        return allOrders;
    }

    private List<CustomerDto> loadCustomers() {
        var firstNames = List.of(
                "John", "Alice", "Bob", "Eve", "Charlie", "David", "Frank", "Grace", "Helen","Ivy",
                "Jack", "Kate", "Liam", "Mia", "Noah", "Olivia", "Paul", "Rose", "Sam", "Tina",
                "Zoe", "Aaron", "Bella", "Chris", "Diana", "Eric", "Fiona", "Gabe", "Holly", "Ivan",
                "Jill", "Karl", "Lara", "Mike", "Nina", "Owen", "Pam", "Ryan", "Sara", "Tom",
                "Vera", "Will", "Xena", "Yuri", "Zara", "Adam", "Becky", "Carl"
        );

        var lastNames = List.of(
                "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor",
                "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia", "Martinez", "Robinson",
                "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", "Hernandez", "King",
                "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson", "Carter",
                "Mitchell", "Perez", "Roberts", "Turner", "Phillips", "Campbell", "Parker", "Evans", "Edwards", "Collins",
                "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey",
                "Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez"
        );

        List<CustomerDto> allCustomers = new ArrayList<>();

        for (String lastName : lastNames) {
            Random random = new Random();
            int nameIndex = random.nextInt(firstNames.size() - 1);

            AddCustomerDto customerDto = new AddCustomerDto(firstNames.get(nameIndex), lastName);
            CustomerDto customer = customerService.addCustomer(customerDto);
            allCustomers.add(customer);
        }

        return allCustomers;
    }

    private List<ProductDto> loadProducts() {
        var producers = loadProducers();
        var names = List.of(
                "Smartphone Pro X", "4K Ultra HD Monitor", "Wireless Gaming Mouse", "Noise-Cancelling Headphones",
                "AI-Powered Smart Speaker", "Gaming Laptop Elite", "Smartwatch Series 5", "Home Security Camera Pro",
                "Portable SSD Drive", "Bluetooth Keyboard Slim", "High-Speed Wi-Fi Router", "Virtual Reality Headset",
                "Tablet Pro 11", "Compact Drone 4K", "Voice Assistant Device", "Ergonomic Office Chair",
                "Graphic Design Tablet", "USB-C Charging Station", "Desktop PC Tower", "Smart Home Hub", "Organic Multivitamins", "Adjustable Yoga Mat", "Essential Oil Diffuser", "Foam Roller Pro",
                "Wireless Blood Pressure Monitor", "Digital Thermometer", "Fitness Resistance Bands",
                "Sleep Tracking Device", "Electric Toothbrush Pro", "Vitamin D Supplement",
                "Protein Powder Shake", "Knee Support Brace", "Posture Corrector", "Meditation Cushion",
                "Handheld Massage Gun", "Infrared Sauna Blanket", "Smart Scale Body Analyzer",
                "Herbal Tea Blend", "Reusable Water Bottle", "Adjustable Dumbbell Set","Online Course Subscription", "Digital Whiteboard", "Ergonomic Study Chair", "Notebook Organizer",
                "Virtual Learning Headset", "Interactive Coding Kit", "Language Learning Software",
                "STEM Robotics Kit", "Wireless Presentation Remote", "Graphing Calculator Pro",
                "Customizable Flashcards", "Educational Puzzle Set", "e-Book Reader Pro",
                "Study Timer Clock", "Noise-Cancelling Study Headphones", "Digital Microscope",
                "Homework Planner App", "Solar System Model", "Periodic Table Poster", "3D Printing Pen",
                "Anti-Theft Backpack", "Travel Adapter Kit", "Portable Power Bank", "Compression Packing Cubes",
                "Travel Neck Pillow", "Compact Travel Umbrella", "Foldable Luggage Scale",
                "Quick-Dry Travel Towel", "Waterproof Action Camera", "Travel-Sized Toiletry Kit",
                "Noise-Cancelling Earplugs", "Passport Wallet Organizer", "Travel Journal Set",
                "Multi-Purpose Swiss Knife", "Collapsible Water Bottle", "Universal Luggage Strap",
                "Travel Shoe Bag", "Mini First Aid Kit", "Portable Bluetooth Speaker", "Travel Guidebook",
                "Budget Tracking App", "Personal Finance Planner", "Stock Market Analytics Tool",
                "Cryptocurrency Wallet", "Business Loan Calculator", "Tax Filing Software",
                "Financial Education eBook", "Smart Credit Card Holder", "Debt Management Toolkit",
                "Investment Portfolio Tracker", "Blockchain Ledger Notebook", "Emergency Fund Calculator",
                "Financial Freedom Course", "Smart Piggy Bank", "Retirement Planning Guide",
                "Expense Management Spreadsheet", "Wealth-Building Audiobook", "Mutual Fund Calculator",
                "Tax Deduction Tracker", "Stock Trading Simulator","Gourmet Coffee Beans", "Electric Coffee Grinder", "Stainless Steel Cookware Set",
                "Organic Spices Kit", "Reusable Food Storage Bags", "Insulated Lunch Box",
                "Digital Kitchen Scale", "Non-Stick Frying Pan", "Electric Wine Opener",
                "Cold Brew Coffee Maker", "High-Speed Blender", "Charcoal BBQ Grill",
                "Professional Chef Knife", "Bamboo Cutting Board", "Smoothie Recipe Book",
                "Automatic Rice Cooker", "Handheld Milk Frother", "Reusable Straws Set",
                "Air Fryer Pro", "Herb Garden Starter Kit", "Waterproof Smartwatch", "Designer Sunglasses", "Comfortable Athletic Shoes",
                "Luxury Leather Wallet", "Casual Cotton T-Shirts", "Classic Denim Jacket",
                "Wireless Earbuds Case", "Premium Wool Scarf", "Breathable Sports Socks",
                "Eco-Friendly Tote Bag", "Custom Printed Hoodie", "Elegant Gold Necklace",
                "Fashionable Beanie Hat", "Silk Pajama Set", "High-Waisted Leggings",
                "Stainless Steel Watch", "Classic Leather Belt", "Lightweight Running Shorts",
                "Formal Business Suit", "Faux Fur Winter Coat", "Streaming Subscription Card", "Wireless Soundbar System", "4K Blu-Ray Player",
                "DJ Turntable Set", "Noise-Cancelling Earphones", "Home Theater Projector",
                "Gaming Console Pro", "LED TV Backlight", "Photo Editing Software",
                "Virtual Reality Gaming Set", "E-Book Subscription Service", "Online Gaming Gift Card",
                "Podcast Recording Microphone", "Portable Karaoke Machine", "Interactive Story App",
                "Action Camera Kit", "Wireless Music Speaker", "Compact Media Storage Box",
                "Custom Movie Poster", "Board Game Collection", "Adjustable Dumbbells", "High-Speed Treadmill", "Yoga Ball Pro", "Resistance Bands Set",
                "Cycling Helmet", "Breathable Running Shoes", "Sports Water Bottle",
                "Fitness Tracker Watch", "Home Gym Setup Kit", "Jump Rope Pro",
                "Kettle bell Weight Set", "Folding Exercise Mat", "Foam Roller Kit",
                "Athletic Compression Wear", "Hiking Backpack", "Performance Running Socks",
                "Adjustable Weight Bench", "Protein Shaker Bottle", "Cycling Gloves", "Speed Agility Ladder",
                "Smart Thermostat", "Robot Vacuum Cleaner", "LED Desk Lamp", "Portable Air Purifier",
                "Bamboo Shelving Unit", "Ergonomic Office Chair", "Adjustable Standing Desk",
                "Wireless Doorbell Camera", "Ultrasonic Humidifier", "Decorative Throw Pillow",
                "Indoor Herb Planter", "Multi-Tool Kitchen Scissors", "Insulated Curtain Panels",
                "Adjustable Bed Frame", "Cordless Electric Kettle", "Modular Sofa Set",
                "Automatic Pet Feeder", "Compact Laundry Dryer", "Wall-Mounted Bookshelf", "Foldable Step Ladder"
        );

        List<ProductDto> allProducts = new ArrayList<>();
        for (String name : names) {
            Random random = new Random();
            int price = random.nextInt(1000);
            int quantity = random.nextInt(100);
            int producerIndex = random.nextInt(producers.size() - 1);
            AddProductDto productDto = new AddProductDto(name, price, quantity, producers.get(producerIndex));
            ProductDto product = productService.addProduct(productDto);
            allProducts.add(product);
        }
        return allProducts;
    }

    private List<ProducerDto> loadProducers(){
        var names = List.of(
        "TechNova Solutions", "Blue Horizon Industries", "GreenWave Innovations", "Summit Peak Consulting",
                "NextGen Tech Group", "BrightFuture Enterprises", "Skyline Ventures", "Quantum Dynamics LLC",
                "SilverLine Technologies", "GlobalEdge Partners", "Visionary Designs Co.", "Pinnacle Strategies",
                "EcoSphere Ventures", "TrueNorth Development", "FuturePath Systems", "DynamicCore Solutions",
                "SmartGrid Solutions", "GoldenBridge Consulting", "Apex Innovations", "Infinity Synergies",
                "CrystalWave Networks", "Unified Growth Partners", "StellarEdge Labs", "Vertex Solutions", "Momentum Ventures",
                "PureFlow Technologies", "PrimePath Consulting", "EliteSphere Inc.", "Harmony Ventures", "ClearView Systems");

        var phoneNumbers = List.of(
                123456789L, 234567890L, 345678901L, 456789012L, 567890123L,
                678901234L, 789012345L, 890123456L, 901234567L, 12345678L,
                234567890L, 345678901L, 456789012L, 567890123L, 678901234L,
                789012345L, 890123456L, 901234567L, 12345678L, 123456789L,
                234567890L, 345678901L, 456789012L, 567890123L, 678901234L,
                789012345L, 890123456L, 901234567L, 12345678L, 123456789L
        );

        var mails = List.of(
        "contact@technova.com", "info@bluehorizon.com", "support@greenwave.com", "hello@summitpeak.com",
                "team@nextgentech.com",
                "contact@brightfuture.com", "info@skylineventures.com", "support@quantumdynamics.com", "hello@silverline.com",
                "team@globaledge.com",
                "contact@visionarydesigns.com", "info@pinnaclestrategies.com", "support@ecospherelabs.com",
                "hello@truenorth.com", "team@futurepath.com",
                "contact@dynamiccore.com", "info@smartgrid.com", "support@goldenbridge.com", "hello@apexinnovations.com",
                "team@infinitysynergies.com",
                "contact@crystalwave.com", "info@unifiedgrowth.com", "support@stellaredge.com", "hello@vertexsolutions.com",
                "team@momentumventures.com",
                "contact@pureflow.com", "info@primepath.com", "support@elitesphere.com", "hello@harmonyventures.com",
                "team@clearview.com"
        );

        List<ProducerDto> allProducers = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            AddProducerDto producerDto = new AddProducerDto(names.get(i), mails.get(i), phoneNumbers.get(i));
            ProducerDto producer = producerService.addProducer(producerDto);
            allProducers.add(producer);
        }

        return allProducers;
    }
}
